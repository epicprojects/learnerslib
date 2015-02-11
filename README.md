Learners Library
================

Learners is native java-based machine learning library inspired by weka, Its also compatible with Android. Following algorithms are implemented:
- Bayesian belief network
- Artifical Neural Network (back propagation)
- Support Vector Machines (Various kernels included)

It also includes data imputation algorithms i.e Neighbourhood rough set, K-nearest neighbour etc.


Tool/Framework used:
  - JDK 1.7
  - NetBeans


Usage:

```

DataSet dataset = new DataSet("weather");
DataSetLoader dl = new DataSetLoader();
DataSetLoader.setDATABASE_URL("jdbc:mysql://localhost:3306/test");
        
dataset = dl.DatasetLoader("select * from weather",dataset);
             
//NaiveBayes 
NaiveBayes nb = new NaiveBayes();
Classifer c = nb.Train(dataset);

//Print Training Summary
System.out.println(c.StringSummary());

```
