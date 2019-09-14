package net.thumbtack.school.ttschool;

import java.util.*;

public class School {

    private String name;
    private int year;
    private Set<Group> groups;

    public School(String name, int year) throws TrainingException {
        setName(name);
        this.year = year;
        this.groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals(""))
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        else this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }


    public void addGroup(Group group) throws TrainingException {
        for (Group group1 : groups) {
            if (group1.getName().contains(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }
        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        if (groups.contains(group)) groups.remove(group);
        else throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
    }

    public void removeGroup(String name) throws TrainingException {
        if (!groups.removeIf(group -> name.equals(group.getName())))
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year &&
                Objects.equals(name, school.name) &&
                Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, groups);
    }
}
