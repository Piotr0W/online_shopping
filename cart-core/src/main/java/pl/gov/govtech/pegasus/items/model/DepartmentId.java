package pl.gov.govtech.pegasus.items.model;

import java.io.Serializable;

import static validator.Validator.requireNonNull;

public class DepartmentId implements Serializable, Comparable<DepartmentId> {

    private Department department;

    private long id;

    private DepartmentId() {
    }

    public DepartmentId(Department department, Long id) {
        this.department = requireNonNull(department, "department");
        this.id = requireNonNull(id, "id");
    }

    public static DepartmentId of(Department department, long id) {
        return new DepartmentId(department, id);
    }

    public Department getDepartment() {
        return department;
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(DepartmentId other) {
        int departmentComparison = getDepartment().compareTo(other.getDepartment());
        if (departmentComparison != 0) return departmentComparison;
        return Long.signum(getId() - other.getId());
    }
}
