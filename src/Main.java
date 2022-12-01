import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso JAva");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(4);;

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("descricao curso java");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria java");
        mentoria.setDescricao("descricao mentoria java");
        mentoria.setData(LocalDate.now());


       // System.out.println(curso1);
       // System.out.println(curso2);
       // System.out.println(mentoria);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devJackson = new Dev();
        devJackson.setNome("Jackson");
        devJackson.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos" + devJackson.getConteudoInscritos());
        devJackson.progredir();
        System.out.println("Conteudos Inscritos" + devJackson.getConteudoInscritos());
        System.out.println("Conteudos Concluidos" + devJackson.getConteudosConcluidos());
        System.out.println("XP:" + devJackson.calcularTotalXp());

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos" + devJoao.getConteudosConcluidos());
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("Conteudos Inscritos" + devJoao.getConteudosConcluidos());
        System.out.println("Conteudos Concluidos" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());
    }
}