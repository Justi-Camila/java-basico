package javabasico.carro;

public class Carro {
    private int velocidade;
    private boolean parado = true;

    public void aumentarVelocidade() {

        if (getVelocidade() >= 200) {
            System.out.println("A velocidade já está no limite");
        } else if (!parado) {
            setVelocidade(getVelocidade() + 10);
            System.out.println("Velocidade atual: " + getVelocidade());
            System.out.println();
        } else {
            System.out.println("Você precisa arrancar o carro primeiro");
        }
    }

    public void diminuirVelocidade() {
        if (!parado && getVelocidade() > 0) {
            setVelocidade(getVelocidade() - 10);
            System.out.println("Velocidade atual: " + getVelocidade());
            System.out.println();
            if (getVelocidade() == 0) {
                System.out.println("O carro está parado\n");
                parado = true;
            }
        } else {
            System.out.println("O carro está parado, você precisa arrancá-lo\n");
        }

    }

    public void buzinar() {
        System.out.println("bee bee\n");
    }

    public void pararCarro() {
        if (parado) {
            System.out.println("O carro já está parado\n");
        } else if (getVelocidade() == 0) {
            parado = true;
        } else {
            System.out.println("O carro está em movimento e não pode ser parado");
        }

    }

    public void arrancarCarro() {
        if (getVelocidade() == 0) {
            parado = false;
            setVelocidade(10);
            System.out.println("Você arrancou o carro");
            System.out.println("Velocidade atual: " + getVelocidade());
            System.out.println();
        } else {
            System.out.println("O carro já está arrancado\n");
        }
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
}
