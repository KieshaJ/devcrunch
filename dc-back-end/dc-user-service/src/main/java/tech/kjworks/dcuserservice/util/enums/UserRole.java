package tech.kjworks.dcuserservice.util.enums;

public enum UserRole {
    DC_USER("DC_USER"),
    DC_MOD("DC_MOD"),
    DC_ADMIN("DC_ADMIN"),
    DC_SYS_ADMIN("DC_SYS_ADMIN");

    private String value;

    private UserRole(String value) {
        this.value = value;
    }

    public boolean isDcUserRole() {
        return this.value.equals(DC_USER.value);
    }

    public boolean isDcModRole() {
        return this.value.equals(DC_MOD.value);
    }

    public boolean isDcAdminRole() {
        return this.value.equals(DC_ADMIN.value);
    }

    public boolean isDcSysAdminRole() {
        return this.value.equals(DC_SYS_ADMIN.value);
    }
}
