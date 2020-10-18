# How to run this project?

## Compile
```mvn compile```



## Run
```mvn exec:java -Dexec.mainClass="Ingest" -Dexec.args="mixtape.json changes.json output.json"```

Here we are running main class Ingest.java with arguments

1. mixtape.json in src/main/resources folder

  2. changes.json in src/main/resources folder

3. output.json (User defined name)

## How to scale this application when input file is large


When input file is very large, we might not be able to load complete object model in memory. In this case, We should use streaming API to read json and write to file simultaneously. In this approach, we can have changes file loaded into memory and we can modify input data according to changes file before writing them to file. In java, we can use GSON Streaming API for processing very large json files.

## How to scale this application when changes file is large

When changes file is really large, we can deserialize `input` file and build object model. We can build the 3 different HashMap to find objects in `O(1)` complexity. We will stream the changes file and modify this object model concurrently. After changes file is fully processed, we can write object model to file.

## How to scale this application when input and changes file is large

When both input file and changes file are really large and none of these could be loaded in memory, we have to divide both files into smaller chunks streaming these files and repeat modifying data of all chunks of mixtape.json for all chunk of changes.json.