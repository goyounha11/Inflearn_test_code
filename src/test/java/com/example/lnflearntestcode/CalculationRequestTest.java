package com.example.lnflearntestcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationRequestTest {

  @Test
  public void 유효한_숫자를_파싱할_수_있다() {
    //given
    String[] parts = new String[] {"2", "+", "3"};

    //when

    CalculationRequest calculationRequest = new CalculationRequest(parts);

    //then

    assertEquals(2, calculationRequest.getNum1());
    assertEquals("+", calculationRequest.getOperator());
    assertEquals(3, calculationRequest.getNum2());
  }

  @Test
  public void 세자리_숫자가_넘어가는_유효한_숫자를_파싱할_수_있다() {
    //given
    String[] parts = new String[] {"2232", "+", "123"};

    //when

    CalculationRequest calculationRequest = new CalculationRequest(parts);

    //then

    assertEquals(2232, calculationRequest.getNum1());
    assertEquals("+", calculationRequest.getOperator());
    assertEquals(123, calculationRequest.getNum2());
  }

  @Test
  public void 유효한_길이의_숫자가_들어오지_않으면_에러를_던진다() {
    //given
    String[] parts = new String[] {"2232", "+"};

    //when
    //then

    assertThrows(BadRequestException.class, () -> {
      new CalculationRequest(parts);
    });
  }

  @Test
  public void 유효한_연산자가_들어오지_않으면_에러를_던진다() {
    //given
    String[] parts = new String[] {"2232", "x", "123"};

    //when
    //then

    assertThrows(InvalidOperatorException.class, () -> {
      new CalculationRequest(parts);
    });
  }

  @Test
  public void 유효한_연산자의_길이가_들어오지_않으면_에러를_던진다() {
    //given
    String[] parts = new String[] {"2232", "+1", "123"};

    //when
    //then

    assertThrows(InvalidOperatorException.class, () -> {
      new CalculationRequest(parts);
    });
  }
}