package com.taskTopjava.util;

import com.taskTopjava.model.HasId;
import com.taskTopjava.util.exception.IllegalRequestDataException;
import com.taskTopjava.util.exception.NotFoundException;

public class ValidationUtils {

    private ValidationUtils() {}

    public static <T>T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static void checkNotFoundWithId(boolean found, int id) { checkNotFound(found, "id=" + id); }

    public static <T>T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    public static void checkNotFound(boolean found, String arg) {
        if (!found) {
            throw new NotFoundException(arg);
        }
    }

    public static void checkNew(HasId been) {
        if (!been.isNew()) {
            throw new IllegalRequestDataException(been + " must be new (id=null)");
        }
    }

    public static void assureIdConsistent(HasId been, int id) {
        if (been.isNew()) {
            been.setId(id);
        } else if (been.id() != id) {
            throw new IllegalRequestDataException(been + "must be with id=" + id);
        }
    }
}
