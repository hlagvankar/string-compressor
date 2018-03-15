# string-compressor
Compress the given input string.   
e.g.  
If input string is "QQQFAAABEEEDFFC" its output will be "3QF3AB3ED2FC"  
  
  
# How to run  
1. Download repo  
2. execute `sbt "run AABBCCC"`  
3. You can pass optional parameter minOccurrence like `sbt "run AABBBCC 3"`. This will compress string for some characters which are not less than 'minOccurency' 

# How to test  
execute `sbt clean test`  