package br.senac.tads.dsw.dadospessoais.Validacao;

import org.springframework.stereotype.Component;

import br.senac.tads.dsw.dadospessoais.Pessoa;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class SenhasIguaisValidator
        implements ConstraintValidator<SenhasIguais, Pessoa> {

    private String mensagem;

    @Override
    public void initialize(SenhasIguais annotation) {
        this.mensagem = annotation.message();
    }

    @Override
    public boolean isValid(Pessoa pessoa, ConstraintValidatorContext context) {
        boolean resultado = pessoa.getSenha() != null &&
                pessoa.getSenha().equals(pessoa.getSenhaRepeticao());
        if (!resultado) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(mensagem)
                    .addPropertyNode("senha").addConstraintViolation();
        }
        return resultado;
    }
}