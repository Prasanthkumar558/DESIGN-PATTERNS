
/*

Definition :-

Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. 
Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.


*/


abstract class ModelTrainer {

    public abstract void loadData(String path);
    public abstract void preProcessData();
    public abstract void trainModel();
    public abstract void evaluateModel();
    public abstract void runModel();

    public final void templateMethod(String path){
        loadData(path);
        preProcessData();
        trainModel();
        evaluateModel();
        runModel();
    }

}

class NeuralNetworkModel extends ModelTrainer {

    @Override
    public void loadData(String path){
        System.out.println("Loading data from "+path);
    }

    @Override
    public void preProcessData(){
        System.out.println("Pre Processing Data");
    }

    @Override
    public void trainModel(){
        System.out.println("Training model with the data we pre processed");
    }

    @Override
    public void evaluateModel(){
        System.out.println("Evaluating model which we trainded");
    }

    @Override
    public void runModel(){
        System.out.println("Running Neural Network Model");
    }

}

class LinearRegressionModel extends ModelTrainer {

    public void loadData(String path){
        System.out.println("Loading Data from the path"+path);
    }

    public void trainModel(){
        System.out.println("Training model with the data we pre processed");
    }

    public void evaluateModel(){
        System.out.println("Evaluating model which we trained");
    }

    public void preProcessData(){
        System.out.println("PreProcessing Data");
    }

    public void runModel(){
        System.out.println("Running Linear Regression Model");
    }
}


public class TemplateDesignPattern {
    
    private ModelTrainer modelTrainer;

    public TemplateDesignPattern(ModelTrainer modelTrainer){
        this.modelTrainer = modelTrainer;
    }
    public TemplateDesignPattern() {}

    public void trainModel(String path){
        modelTrainer.templateMethod(path);
    }
    public void main(String[] args) {
        
        ModelTrainer modelTrainer = new NeuralNetworkModel();
        ModelTrainer modelTrainer2 = new LinearRegressionModel();

        TemplateDesignPattern pattern = new TemplateDesignPattern(modelTrainer2);
        pattern.trainModel("c://window/modelTraining/data");
    }
}
