package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.figures.v3.Point2D;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.lang.reflect.Array;

public class FileService {
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(new File(fileName))) {
            fos.write(array);
        }
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        byte[] array;
        try (FileInputStream fis = new FileInputStream(new File(fileName))) {
            array = new byte[fis.available()];
            fis.read(array);
        }
        return array;
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        byte[] array = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(array);
        }
        return array;
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] array1;
        byte[] array2 = new byte[array.length / 2];
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(array.length)) {
            baos.write(array);
            array1 = baos.toByteArray();
        }
        try (ByteArrayInputStream bais = new ByteArrayInputStream(array1)) {
            for (int i = 0; i < array1.length; i++) {
                if (i % 2 == 0) {
                    Array.setByte(array2, i / 2, (byte) bais.read());
                } else bais.skip(1);
            }
        }
        return array2;
    }


    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(fileName)))) {
            bos.write(array);
        }
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            bos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        byte[] array;
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)))) {
            array = new byte[bis.available()];
            bis.read(array);
        }
        return array;
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        byte[] array = new byte[(int) file.length()];
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            bis.read(array);
        }
        return array;
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(file.length());
            raf.writeInt(rect.getTopLeft().getX());
            raf.writeInt(rect.getTopLeft().getY());
            raf.writeInt(rect.getBottomRight().getX());
            raf.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException, ColorException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            return new Rectangle(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), Color.RED);
        }
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        for (Rectangle rect : rects) {
            writeRectangleToBinaryFile(file, rect);
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException, ColorException {
        Rectangle[] rect = new Rectangle[(int) file.length() / 16];
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            for (int i = 0; i < rect.length; i++) {
                raf.seek((int) file.length() - 16 * (i + 1));
                rect[i] = new Rectangle(raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt(), Color.RED);
            }
        }
        return rect;
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeChar(' ');
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeChar(' ');
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeChar(' ');
            dos.writeInt(rect.getBottomRight().getY());
            dos.writeChar(' ');
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws ColorException, IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            Point2D topLeft = new Point2D();
            Point2D buttonRight = new Point2D();
            topLeft.setX(dis.readInt());
            dis.skipBytes(2);
            topLeft.setY(dis.readInt());
            dis.skipBytes(2);
            buttonRight.setX(dis.readInt());
            dis.skipBytes(2);
            buttonRight.setY(dis.readInt());
            return new Rectangle(topLeft, buttonRight, Color.RED);
        }
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeChar('\n');
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeChar('\n');
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeChar('\n');
            dos.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException, ColorException {
        return readRectangleFromTextFileOneLine(file);
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bw.write(trainee.getFirstName() + " " + trainee.getLastName() + " " + trainee.getRating());
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            String str = reader.readLine();
            String[] array = str.split(" ");
            return new Trainee(array[0], array[1], Integer.valueOf(array[2]));
        }
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            bw.write(trainee.getFirstName());
            bw.newLine();
            bw.write(trainee.getLastName());
            bw.newLine();
            bw.write(trainee.getRating());
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            return new Trainee(br.readLine(), br.readLine(), br.read());
        }
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Trainee) ois.readObject();
        }
    }
    //Сериализует Trainee в формате Json в текстовую строку
    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }
    //Десериализует Trainee из текстовой строки с Json-представлением Trainee.
    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }
    // Сериализует Trainee в формате Json в файл, имя файла задается экземпляром класса File.
    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            gson.toJson(trainee, bw);
        }
    }
    //Десериализует Trainee из файла с Json-представлением Trainee, имя файла задается экземпляром класса File.
    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(br, Trainee.class);
        }
    }
}

