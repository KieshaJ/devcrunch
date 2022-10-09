package tech.kjworks.dcpostservice.util.enums;

public enum PostType {
    PROBLEM("PROBLEM"),
    SOLUTION("SOLUTION");

    private String value;

    private PostType(String value) {
        this.value = value;
    }

    public boolean isProblem() {
        return this.value.equals(PROBLEM.value);
    }

    public boolean isSolution() {
        return this.value.equals(SOLUTION.value);
    }
}
