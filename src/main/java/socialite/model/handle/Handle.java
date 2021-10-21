package socialite.model.handle;

import java.util.Optional;

public abstract class Handle {
    protected Optional<String> value;

    /**
     * Getter for value of handle
     *
     * @return value of handle if available, null otherwise
     */
    public String get() {
        return this.value.orElse(null);
    }
}
