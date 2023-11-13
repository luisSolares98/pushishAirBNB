package com.nur.command.checkin.transacction;

import an.awesome.pipelinr.Command;
import com.nur.dtos.TransactionDto;

import java.util.List;

public class GetTransactionQuery implements Command<List<TransactionDto>> {

  public String flightId;

  public GetTransactionQuery(String flightId) {
    this.flightId = flightId;
  }
}
