public class Main {
    public static void main (String[]args){
        NeuralNetwork network = new NeuralNetwork(2);
        double[] inputs = {0.5, 0.8};
        double output = network.feedForward(inputs);
        System.out.println("Output: " + output);
    }
}