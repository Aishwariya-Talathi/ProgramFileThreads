# ProgramFileThreads

A Java program that can open multiple and scan each one to count words in the file. 
A new thread is started for each file so that the file are processed "concurrently".
There are four text files with Hamlet's famous soliloquy that begins "To be, or not to be...".
A separate class (other than main) called Reader opens, reads and counts the words. 
Each file is manipulated by a new Reader object and is done concurrently with each other.

Here is the output from a run (which can be different from run to run as timing differs).

Processing file:file4.txt
Processing file:file3.txt
Processing file:file1.txt
Done in main!
Processing file:file2.txt
file2.txt: 522
file1.txt: 261
file3.txt: 1305
file4.txt: 5220

If in Reader the file does not exist, throw an FileNotFoundException with this message:
File file.txt not found

As can be seen from the output, file4 started first but finished last. Not surprising owing to its size. 
The message "Done in main!" printed before any output from file2.txt is received. 
