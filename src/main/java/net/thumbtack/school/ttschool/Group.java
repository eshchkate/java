package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {

    private String name;
    private String room;
    private List<Trainee> trainees;

    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
        this.trainees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals(""))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        else this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.equals(""))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        else this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (trainees.contains(trainee)) trainees.remove(trainee);
        else throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void removeTrainee(int index) throws TrainingException {
        if (index >= 0 && index < trainees.size())
            trainees.remove(trainees.get(index));
        else throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        Trainee trainee = null;
        for (Trainee trainee1 : trainees) {
            if (trainee1.getFirstName().contains(firstName)) trainee = trainee1;
        }
        if (trainee == null)
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        return trainee;
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        Trainee trainee = null;
        for (Trainee trainee1 : trainees) {
            if (trainee1.getFullName().contains(fullName)) trainee = trainee1;
        }
        if (trainee == null)
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        return trainee;
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(Comparator.comparing(Trainee::getRating).reversed());
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (trainees.size() != 0) {
            trainees.removeIf(trainee -> trainees.size() != 0 && trainee.getRating() !=
                    Collections.max(trainees, Comparator.comparing(Trainee::getRating)).getRating());
            return trainees;
        } else throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public boolean hasDuplicates() {
        Set<Trainee> setTrainees = new HashSet<>(trainees);
        return trainees.size() != setTrainees.size();
    }
}