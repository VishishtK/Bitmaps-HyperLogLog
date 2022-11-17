Explanation of Files

BitMap.java
Uses Bitset as a data strcture to store the bits and implements functions 
like recording flow and query

ProbBitMap.java
It extends BitMap.java and has 2 HashFunctions object one for normal hash
and one for calculating probabilty while recording the packets

HyperLogLog.java
Uses Bitset as a data strcture to store the bits and implements functions 
like recording flow and query. Also has 2 hashfunctions, one for normal hash
and one for geometric hash. Also implements a function for calculating harmoinc
mean

HashFunctions.java
This is the class that implements the hashing functionality with the FNV hashing algorightm.
Each HashTable has an object of HashFunctions class which it uses to Hash the flowID.
This class also helps calculate geometric hash

App.java
This file is the main driver file which initiates the running of the programmed and tests
the algorithms with the dummy values mentioned in the assignment.