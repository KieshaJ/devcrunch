package tech.kjworks.dcpostservice.util.enums;

public enum ContentType {
    TEXT("TEXT"),
    CODE("CODE");

    private String value;

    private ContentType(String value) {
        this.value = value;
    }

    public boolean isText() {
        return this.value.equals("TEXT");
    }

    public boolean isCode() {
        return this.value.equals("CODE");
    }
}
