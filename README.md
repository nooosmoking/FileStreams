### Exercise 00 – File Signatures

To understand the use of this functionality, you should implement an application for analyzing signatures of arbitrary files. This signature allows to define file content type and consists of a set of "magic numbers." These numbers are usually located in the beginning of the file. For example, a signature for PNG file type is represented by first eight bytes of a file that are equal for all PNG images:
```
89 50 4E 47 0D 0A 1A 0A
```

You need to implement an application that accepts the signatures.txt as an input (you should describe it on your own; the file name is explicitly stated in the program code). It contains a list of file types and their respective signatures in the HEX format. Example (specified format of this file must be adhered to):
```
PNG, 89 50 4E 47 0D 0A 1A 0A
GIF, 47 49 46 38 37 61
```
During execution, your program shall accept full paths to files on hard disk and keep the type which file signature corresponds to. The result of program execution should be written to result.txt file. If a signature cannot be defined, the execution result is UNDEFINED (no information should be written into the file).

Example of program operation:
```
$java Program
-> C:/Users/Admin/images.png
PROCESSED
-> C:/Users/Admin/Games/WoW.iso
PROCESSED
-> 42
```
Contents of result.txt file (there is no need to load this file as a result):
```
PNG
GIF
```

### Exercise 01 – Words

Now you need to implement an application that will determine the level of similarity between texts. The simplest and most obvious method to do this is to analyze the frequency of occurrence of the same words.

Let's assume that we have two following texts:
```
1. aaa bba bba a ссс
2. bba a a a bb xxx
```
Let's create a dictionary that contains all words in these texts:
```
a, aaa, bb, bba, ccc, xxx
```
Now let's create two vectors with length equal to that of the dictionary. In i-th position of each vector, we shall reflect the frequency of occurrence of the i-th word in our dictionary in the former and latter texts:
```
A = (1, 1, 0, 2, 1, 0)
B = (3, 0, 1, 1, 0, 1)
```

Thus, each of these vectors characterizes the text in terms of frequency of occurrence of words from our dictionary. Similarity value for these vectors is:
```
Numerator A. B = (1 * 3 + 1 * 0 + 0 * 1 + 2 * 1 + 1 * 0 + 0 * 1) = 5
Denominator ||A|| * ||B|| = sqrt(1 * 1 + 1 * 1 + 0 * 0 + 2  * 2 + 1 * 1 + 0 * 0) * sqrt(3 * 3 + 0 * 0 + 1 * 1 + 1 * 1  + 0 * 0 + 1 * 1) = sqrt(7) * sqrt(12) = 2.64 * 3.46 = 9.1
similarity = 5 / 9.1 = 0.54
```
Your goal is to implement an application that accepts two files as an input (both files are passed as command-line arguments) and displays their similarity comparison outcome (cosine measure).

The program shall also create dictionary.txt file containing a dictionary based on these files.

Example of program operation:
```
$ java Program inputA.txt inputB.txt
Similarity = 0.54
```

### Exercise 02 – File Manager

Let's implement a utility handling the files. The application shall display information about the files, folder content and size, and provide moving/renaming functionality. In essence, the application emulates a command line of Unix-like systems.

The program shall accept as an argument the absolute path to the folder where we start to work, and support the following commands:

`mv` WHAT WHERE – enables to transfer or rename a file if WHERE contains a file name without a path.
`ls` – displays the current folder contents (file and subfolder names and sizes in KB)
`cd FOLDER_NAME` – changes the current directory

Example of the program operation for MAIN directory:
```
$ java Program --current-folder=C:/MAIN
C:/MAIN
-> ls
folder1 60 KB
folder2 90 KB
-> cd folder1
C:/MAIN/folder1
-> ls
image.jpg 10 KB
animation.gif 50 KB
-> mv image.jpg image2.jpg
-> ls
image2.jpg 10 KB
animation.gif 50 KB
-> mv animation.gif ../folder2
-> ls
image2.jpg 10 KB
-> cd ../folder2
C:/MAIN/folder2
-> ls
text.txt 10 KB
Program.java 80 KB
animation.gif 50 KB
-> exit
```
