package net.msgnetconomy.travel.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class AdditionalExpenseDTO implements Serializable {

    private List<ExpenseDTO> expenses;
}
