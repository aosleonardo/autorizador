package br.com.autorizador.infrastructure.repository;

import br.com.autorizador.adapters.exception.UnprocessableEntityException;
import br.com.autorizador.domain.Cartao;
import br.com.autorizador.domain.dto.CartaoDTO;
import br.com.autorizador.domain.ports.repository.CartaoRepositoryPort;
import br.com.autorizador.infrastructure.entity.CartaoEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CartoesRepositoty implements CartaoRepositoryPort {

    private final SpringCartoesRepository springCartoesRepository;

    public CartoesRepositoty(SpringCartoesRepository springCartoesRepository) {
        this.springCartoesRepository = springCartoesRepository;
    }

    @Override
    public Optional<CartaoEntity> findByNumeroCartao(String numeroCartao) {
        return springCartoesRepository.findByNumeroCartao(numeroCartao);
    }

    @Override
    public Optional<CartaoEntity> findByNumeroCartaoAndSenha(String numeroCartao, String senha) {
        return springCartoesRepository.findByNumeroCartaoAndSenha(numeroCartao, senha);
    }

    @Override
    public CartaoDTO save(Cartao cartao) {
        final CartaoEntity cartaoEntity = new CartaoEntity(cartao.getNumeroCartao(),cartao.getSenha());
        final CartaoDTO cartaoDTO = new CartaoDTO(cartao.getSenha(), cartao.getNumeroCartao());
        try {
            springCartoesRepository.save(cartaoEntity);
        }catch (Exception e) {
            throw new UnprocessableEntityException("Numero de cartão já cadastrado");
        }
        return cartaoDTO;
    }
}
