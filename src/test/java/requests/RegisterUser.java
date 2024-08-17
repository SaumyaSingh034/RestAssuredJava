package requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUser {
    private String email;
    private String password;
}
