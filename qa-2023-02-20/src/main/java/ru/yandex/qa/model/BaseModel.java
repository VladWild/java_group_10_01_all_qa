package ru.yandex.qa.model;

public abstract class BaseModel<T> {

    protected T id;

    public BaseModel() {
    }

    public T getId() {
        return this.id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (!(o instanceof BaseModel)) {
            return false;
        } else {
            BaseModel that = (BaseModel) o;
            if (!that.getClass().equals(this.getClass())) {
                return false;
            } else {
                return this.id != null && this.id.equals(that.id);
            }
        }
    }

    public int hashCode() {
        return this.id != null ? this.id.hashCode() : 0;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "{id=" + this.id + '}';
    }
}
