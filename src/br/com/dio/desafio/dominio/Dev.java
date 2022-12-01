package br.com.dio.desafio.dominio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

//Set - permitie adicionar apenas elementos unicos.
public class Dev {

    private String nome;
    private Set<Conteudo> conteudoInscritos = new HashSet<>();
    private Set<Conteudo> conteudosConcluidos = new HashSet<>();


    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudoInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }


    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudoInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudoInscritos.remove(conteudo.get());
        }else {
            System.err.println("Você não esta matriculado em nenhum conteúdo");
        }
    }

    public double calcularTotalXp(){
       return this.conteudosConcluidos
                .stream()
                .mapToDouble(conteudo ->conteudo.calcularXp())
                .sum();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudoInscritos() {
        return conteudoInscritos;
    }

    public void setConteudoInscritos(Set<Conteudo> conteudoInscritos) {
        this.conteudoInscritos = conteudoInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudoInscritos, dev.conteudoInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudoInscritos, conteudosConcluidos);
    }
}
