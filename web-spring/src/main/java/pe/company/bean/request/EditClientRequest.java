package pe.company.bean.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class EditClientRequest {
    private Long id;
    private String name;
}
