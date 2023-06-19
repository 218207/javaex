import java.util.Random;

public class Neuron {
    private double[] weights; // веса связей с предыдущими нейронами
    private double bias; // смещение нейрона
    private double output; // выходное значение нейрона

    // конструктор класса, принимающий количество входов нейрона
    public Neuron(int numInputs) {
        Random random = new Random();
        weights = new double[numInputs];
        for (int i = 0; i < numInputs; i++) {
            weights[i] = random.nextDouble() * 2 - 1; // случайные значения весов
        }
        bias = random.nextDouble() * 2 - 1; // случайное значение смещения
    }

    // функция прямого распространения нейрона
    public double feedForward(double[] inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        sum += bias;
        output = sigmoid(sum); // применяем функцию активации
        return output;
    }

    // функция активации - сигмоида
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}
