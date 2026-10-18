package javabasico.tv;

public class Tv {
    private int volume = 10;
    private boolean mutado = false;
    private boolean ligada = false;

    public void ligarTv() {
        if (!ligada) {
            ligada = true;
            System.out.println("A TV foi ligada");
        } else {
            System.out.println("A TV já está ligada");
        }
    }

    public void desligarTv() {
        if (ligada) {
            ligada = false;
            System.out.println("A TV foi desligada");
        } else {
            System.out.println("A TV já está desligada");
        }
    }

    public void alterarVolume(int escolha, int valor) {
        if (mutado) {
            mutado = false;
            System.out.println("A TV foi desmutada");
        }

        if (escolha == 1) {
            if (getVolume() >= 100) {
                System.out.println("Não é possível aumentar o volume acima de 100");
            } else {
                setVolume(getVolume() + valor);
                mostrarVolume();
            }

        } else if (escolha == 2) {
            if (getVolume() <= 0) {
                System.out.println("Não é possível dimunuir o volume abaixo de 0");
                mostrarVolume();
            } else {
                setVolume(getVolume() - valor);
                mostrarVolume();
            }

        } else {
            System.out.println("Escolha Inválida");
        }
    }

    public void alterarCanal(int escolha) {
        if (escolha == 1) {
            System.out.println("Você foi para o próximo canal");
        } else if (escolha == 2) {
            System.out.println("Você foi para o canal anterior");
        } else {
            System.out.println("Escolha Inválida");
        }
    }

    public void alterarCanalEspecifico(int valor) {
        System.out.printf("Você foi para o canal %s \n", valor);
    }

    public void mutar() {
        if (!ligada) {
           System.out.println("A TV está desligada");
        } else if (!mutado) {
            System.out.println("A TV foi mutada");
            mutado = true;
        } else {
            mutado = false;
            System.out.println("A TV foi desmutada");
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void mostrarVolume() {
        System.out.println("O volume atual é " + getVolume());
        System.out.println();
    }

    public boolean isLigada() {
        return ligada;
    }
}
