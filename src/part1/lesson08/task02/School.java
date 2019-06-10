package part1.lesson08.task02;

import part1.lesson08.task01.Library;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class School implements Externalizable {
    private Integer pupils;
    private Library library;
    private String name;

    /**
     * School консутрктор по умолчанию
     */
    public School() {
    }

    /**
     * School консутрктор
     * @param pupils - int ученики,
     * @param library - объект библиотека
     * @param name - строка имя школы
     */
    public School(Integer pupils, Library library, String name) {
        this.pupils = pupils;
        this.library = library;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Scool{" +
                "pupils=" + pupils +
                ", library=" + library +
                '}';
    }

    /**
     * writeExternal
     * @param out - Записываемый обьект
     * @throws IOException
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(pupils);
        out.writeObject(library);
    }

    /**
     *
     * @param in - входящий объект
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        pupils = (Integer) in.readObject();
        library = (Library) in.readObject();
    }
}
