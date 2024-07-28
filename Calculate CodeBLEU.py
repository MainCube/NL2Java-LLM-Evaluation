from codebleu import calc_codebleu
import re
import os
import numpy as np

#Bereinigen der Java Klasse (Kommentare entfernen, Imports entfernen, )
def remove_imports_and_comments(file_path):
    with open(file_path, 'r') as file:
        java_code = file.read()

    # Remove import statements
    java_code = re.sub(r'^\s*import\s+[a-zA-Z0-9_.]+;\s*$', '', java_code, flags=re.MULTILINE)

    # Remove single line comments
    java_code = re.sub(r'//.*', '', java_code)

    # Remove multi-line comments
    java_code = re.sub(r'/\*.*?\*/', '', java_code, flags=re.DOTALL)

    # Remove leading and trailing whitespace
    java_code = java_code.strip()

    return java_code


Ordner = "CODE\\3190. Find Minimum Operations to Make All Elements Divisible by Three"
model_names = ["OpenAI GPT-4o", "Google Gemini-1.5-Pro", "Meta Code Llama Instruct 70B"]
iteration_names = inner_files = [f"{i}.java" for i in range(1, 6)]



reference_path= os.path.join (Ordner, "CodeBLEU reference.java")
reference = remove_imports_and_comments(reference_path)

for model in model_names:
    codebleu_values = []
    print("-----------------" + model + "-----------------")
    for file in iteration_names:
        file_path = os.path.join(Ordner, model, file)
        prediction = remove_imports_and_comments(file_path)
        result = calc_codebleu([reference], [prediction], lang="java", weights=(0.1, 0.1, 0.4, 0.4), tokenizer=None)
        result = result['codebleu']
        rounded_value = round(result, 3)
        codebleu_values.append(rounded_value)
        print(rounded_value)
    values_array = np.array(codebleu_values)
    mean_value = np.mean(values_array)
    print("Mean:  " + str(round(mean_value, 3)))
