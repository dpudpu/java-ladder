package ladder.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Player {
    private static final int NAME_LENGTH_CONDITION = 5;
    private static final Set<String> EXCEPT_NAME = new HashSet<>();

    static {
        EXCEPT_NAME.add("all");
    }

    private final String name;
    private final int position;

    public Player(final String name, final int position) {
        this.name = validName(name);
        this.position = position;
    }

    private String validName(String name) {
        String trimmedName = trimName(name);
        validateName(trimmedName);
        return trimmedName;
    }

    private void validateName(String name) {
        validateNameSize(name);
        validateExceptName(name);
    }

    private void validateExceptName(String name) {
        if (EXCEPT_NAME.contains(name)) {
            throw new IllegalArgumentException(name + "은 사용될 수 없는 이름입니다.");
        }
    }

    private void validateNameSize(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1글자 이상 입력해주세요.");
        }
        if (name.length() > NAME_LENGTH_CONDITION) {
            throw new IllegalArgumentException("이름은 " + NAME_LENGTH_CONDITION + "글자 이하로 입력해주세요.");
        }
    }

    private String trimName(String name) {
        return name.trim();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
