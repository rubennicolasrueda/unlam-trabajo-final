package com.example.demo.service;

import com.example.demo.dto.TrainingRecord;
import com.example.demo.model.Categoria;
import com.example.demo.model.Ingrediente;
import com.example.demo.model.Receta;
import org.springframework.stereotype.Service;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RecetaBayesService {

    NaiveBayes classifier; // = new NaiveBayes();
    Instances trainInstances;

    public void entrenar(List<Receta> allRecipes, Set<Receta> likedRecipes, List<Ingrediente> ingredientes) throws Exception {

        List<TrainingRecord> trainingRecords = getTrainingRecords(allRecipes, likedRecipes, ingredientes);
        trainingRecords.forEach(System.out::println);
        trainInstances = buildInstance(trainingRecords);

        classifier = new NaiveBayes();
        classifier.buildClassifier(trainInstances);

    }

    public Receta predecirReceta( List<Ingrediente> ingredientes, Receta receta) throws Exception {

        Receta recetaRecomendada = null;

        // Assuming you have a method to get ingredient data for a new recipe
        double[] valuesForPrediction = new double[trainInstances.numAttributes()];

        int indx = 0;
        // Presencia de ingredientes
        Set<Ingrediente> recetaIngredientes = receta.getRecetaIngredientes();
        for (Ingrediente ingrediente : ingredientes) {
            valuesForPrediction[indx] = recetaIngredientes.contains(ingrediente) ? 1 : 0;
            ++indx;
        }

        // Leave the liked attribute as missing, which is at the last index
        valuesForPrediction[valuesForPrediction.length - 1] = Utils.missingValue();

        // Create an instance and add it to the dataset
        Instance instanceToPredict = new DenseInstance(1.0, valuesForPrediction);
        instanceToPredict.setDataset(trainInstances);  // Set the same dataset structure

        double predictedClass = classifier.classifyInstance(instanceToPredict);
        String predictedLabel = trainInstances.classAttribute().value((int) predictedClass);

        if (predictedLabel.equals("1") && recetaRecomendada == null) {
            recetaRecomendada = receta;
        }

        System.out.println("Recipe ID: " + receta.getTitulo() + ", Predicted liked status: " + predictedLabel);
        return recetaRecomendada;
    }

    private void predict(Instances trainInstances, List<Ingrediente> allIngredientes, Receta receta) {

        /*
        // Assuming you have a method to get ingredient data for a new recipe
        double[] valuesForPrediction = new double[trainInstances.numAttributes()];

        int indx = 0;
        // Presencia de ingredientes
        Set<Ingrediente> recetaIngredientes = receta.getRecetaIngredientes();
        for (Ingrediente ingrediente : allIngredientes) {
            valuesForPrediction[indx] = recetaIngredientes.contains(ingrediente) ? 1 : 0;
            ++indx;
        }

        // Leave the liked attribute as missing, which is at the last index
        valuesForPrediction[valuesForPrediction.length - 1] = Utils.missingValue();

        // Create an instance and add it to the dataset
        Instance instanceToPredict = new DenseInstance(1.0, valuesForPrediction);
        instanceToPredict.setDataset(trainInstances);  // Set the same dataset structure

        double predictedClass = classifier.classifyInstance(instanceToPredict);
        String predictedLabel = dataSet.classAttribute().value((int) predictedClass);

        System.out.println("Recipe ID: " + recipeId + ", Predicted liked status: " + predictedLabel);

         */

    }

    private List<TrainingRecord> getTrainingRecords(List<Receta> allRecipes, Set<Receta> likedRecipes, List<Ingrediente> ingredientes){
        List<TrainingRecord> trainingRecords = new ArrayList<>();
        // Registros de entrenamiento para recetas guardadas (Liked = 1)

        likedRecipes.forEach(receta -> trainingRecords.add(createTrainingRecord(receta, ingredientes, null, 1)));

        allRecipes.stream()
                .filter(receta -> !likedRecipes.contains(receta))
                .forEach(receta -> trainingRecords.add(createTrainingRecord(receta, ingredientes, null, 0)));

        /*
        // Registros de entrenamiento para recetas no guardadas (Liked = 0)
        for (Receta receta : allRecipes) {
            if (!likedRecipes.contains(receta)) {
                // TrainingRecord record = ;
                trainingRecords.add(createTrainingRecord(receta, ingredientes, null, 0));
                //System.out.println(record);
            }
        }
         */
        return trainingRecords;
    }

    // se obtiene el usuario, la receta, todos los ingredientes, todas las categorias y su gusto
    private TrainingRecord createTrainingRecord(Receta receta, List<Ingrediente> allIngredients, List<Categoria> allCategories, int liked) {
        TrainingRecord record = new TrainingRecord(receta.getId(), liked);

        // Presencia de ingredientes
        Set<Ingrediente> recetaIngredientes = receta.getRecetaIngredientes();
        for (Ingrediente ingrediente : allIngredients) {
            record.ingredientPresence.put(ingrediente.getNombre(), recetaIngredientes.contains(ingrediente) ? 1 : 0);
        }
/*
        // Presencia de categorías
        Set<Categoria> recetaCategorias = receta.getCategorias();
        for (Categoria categoria : allCategories) {
            record.categoryPresence.put(categoria.getId().intValue(), recetaCategorias.contains(categoria) ? 1 : 0);
        }
 */
        return record;
    }

    private Instances buildInstance(List<TrainingRecord> trainingSet) {

        ArrayList<Attribute> attributes = new ArrayList<>();
        // attributes.add(new Attribute("recipeId"));
        //Integer ingredientesSize = trainingSet.get(0).getIngredientPresence().size();

        for (Map.Entry<String, Integer> ingrediente : trainingSet.get(0).getIngredientPresence().entrySet()) {
            attributes.add(new Attribute(ingrediente.getKey()));
            System.out.println( "ingrediente KEY " + ingrediente.getKey());
        }

        // Define 'liked' as a nominal attribute
        ArrayList<String> likedLabels = new ArrayList<>();
        likedLabels.add("0"); // Not liked
        likedLabels.add("1"); // Liked
        attributes.add(new Attribute("liked",likedLabels));

        attributes.forEach(System.out::println);

        Instances dataSet = new Instances("Recetas", attributes, trainingSet.size());
        dataSet.setClassIndex(dataSet.numAttributes() - 1); // Set 'liked' as the class attribute

        // se cargan los datos  TODOOOO

        for (TrainingRecord record : trainingSet) {

            int indx = 0;

            double[] values = new double[dataSet.numAttributes()];

            // values[0] = record.getRecipeId();

            for (Map.Entry<String, Integer> ingrediente : record.getIngredientPresence().entrySet()) {
                //values[1 + indx] = ingrediente.getValue(); // +1 offset for userId and recipeId
                values[indx] = ingrediente.getValue(); // +1 offset for userId and recipeId
                System.out.println(indx + " VALUES ING " + values[indx]);
                ++indx;
            }
            values[attributes.size() - 1] = record.getLiked() == 1 ? 1.0 : 0.0;
            System.out.println(indx + " VALUES LIKE " + values[attributes.size() - 1]);

            dataSet.add(new DenseInstance(1.0, values));

        }

        return dataSet;
    }

    // Cargar los datos de entrenamiento y entrenar el modelo
    private void trainModel(Instances dataset) throws Exception {
        // Build and evaluate the classifier
        NaiveBayes classifier = new NaiveBayes();
        classifier.buildClassifier(dataset);
    }

    /*
    // se obtiene el usuario, la receta, todos los ingredientes, todas las categorias y su gusto
    private TrainingRecord createTrainingRecord(Usuario user, Receta receta, List<Ingrediente> allIngredients, List<Categoria> allCategories, int liked) {
        TrainingRecord record = new TrainingRecord(user.getId(), receta.getId(), liked);

        // Presencia de ingredientes
        Set<Ingrediente> recetaIngredientes = receta.getIngredientes();
        for (Ingrediente ingrediente : allIngredients) {
            record.ingredientPresence.put(ingrediente.getId().intValue(), recetaIngredientes.contains(ingrediente) ? 1 : 0);
        }
        // Presencia de categorías
        Set<Categoria> recetaCategorias = receta.getCategorias();
        for (Categoria categoria : allCategories) {
            record.categoryPresence.put(categoria.getId().intValue(), recetaCategorias.contains(categoria) ? 1 : 0);
        }

        return record;
    }
    */

}

