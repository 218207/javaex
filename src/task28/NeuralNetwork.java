public class NeuralNetwork {
    private Neuron[] neurons; // массив нейронов

    // конструктор класса, принимающий количество входов нейронов
    public NeuralNetwork(int numInputs) {
        neurons = new Neuron[2];
        neurons[0] = new Neuron(numInputs);
        neurons[1] = new Neuron(numInputs);
    }

    // функция прямого распространения нейронной сети
    public double feedForward(double[] inputs) {
        double[] outputs = new double[2];
        outputs[0] = neurons[0].feedForward(inputs);
        outputs[1] = neurons[1].feedForward(inputs);
        return sigmoid(outputs[0] + outputs[1]); // применяем функцию активации
    }

    // функция активации - сигмоида
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}
