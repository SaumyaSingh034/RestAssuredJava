package requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUser {
    private String name;
    private String job;
}
