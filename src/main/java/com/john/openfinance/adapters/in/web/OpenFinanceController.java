package com.john.openfinance.adapters.in.web;

import com.john.openfinance.adapters.in.web.dto.OpenFinanceDtos;
import com.john.openfinance.core.usecases.OpenFinanceMockServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/openfinance")
@Tag(name = "Open Finance Data API", description = "Endpoints para consulta de bancos, saldos e transações consolidadas")
public class OpenFinanceController {

    private final OpenFinanceMockServices mockServices;

    // O Spring injeta o UseCase aqui
    public OpenFinanceController(OpenFinanceMockServices mockServices) {
        this.mockServices = mockServices;
    }

    @GetMapping("/banks")
    @Operation(summary = "Listar Bancos", description = "Retorna a lista de instituições conectadas ao usuário.")
    public ResponseEntity<List<OpenFinanceDtos.BankResponse>> listBanks() {
        // 1. Chama a regra de negócio (retorna Domínio)
        var domainInstitutions = mockServices.listAvailableBanks();

        // 2. Converte (Mapeia) o Domínio para o DTO de Saída
        var response = domainInstitutions.stream()
                .map(inst -> new OpenFinanceDtos.BankResponse(inst.code(), inst.name()))
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/banks/{bankCode}/balances")
    @Operation(summary = "Consultar Saldo", description = "Retorna o saldo atual de uma instituição específica.")
    public ResponseEntity<OpenFinanceDtos.BalanceResponse> getBalance(
            @Parameter(description = "Código do banco (ex: 341)", example = "341")
            @PathVariable String bankCode) {

        var domainBalance = mockServices.getBalanceForBank(bankCode);
        var response = new OpenFinanceDtos.BalanceResponse(domainBalance.currency(), domainBalance.amount());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/banks/{bankCode}/transactions")
    @Operation(summary = "Consultar Transações", description = "Retorna o extrato de transações de uma instituição específica.")
    public ResponseEntity<List<OpenFinanceDtos.TransactionResponse>> getTransactions(
            @Parameter(description = "Código do banco (ex: 341)", example = "341")
            @PathVariable String bankCode) {

        var domainTransactions = mockServices.getTransactionsForBank(bankCode);
        var response = domainTransactions.stream()
                .map(tx -> new OpenFinanceDtos.TransactionResponse(tx.id(), tx.timestamp(), tx.amount(), tx.Description()))
                .toList();

        return ResponseEntity.ok(response);
    }

}
