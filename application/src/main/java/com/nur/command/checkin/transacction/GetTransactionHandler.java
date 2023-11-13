package com.nur.command.checkin.transacction;

import an.awesome.pipelinr.Command;
import com.nur.dtos.TransactionDto;
import com.nur.core.BusinessRuleValidationException;

import java.util.List;
import java.util.UUID;
import com.nur.model.Transaccion;
import org.springframework.stereotype.Component;
import com.nur.repositories.TransactionRepository;
import com.nur.utils.TransaccionMapper;

@Component
public class GetTransactionHandler
  implements Command.Handler<GetTransactionQuery, List<TransactionDto>> {

  private final TransactionRepository seatRepository;

  public GetTransactionHandler(TransactionRepository seatRepository) {
    this.seatRepository = seatRepository;
  }

  @Override
  public List<TransactionDto> handle(GetTransactionQuery command) {
    try {
      List<Transaccion> seats = seatRepository.findByTransactionCode(
        UUID.fromString(command.flightId)
      );
      return seats.stream().map(TransaccionMapper::from).toList();
    } catch (BusinessRuleValidationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
