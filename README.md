# DECIDE() program
Group 2

Assignment 1

## Purpose
The DECIDE() function determines if an interceptor should be launched based upon input radar tracking information. It is a part of a hypothetical anti-ballistic missile system called the Launch Interceptor Program.

## DECIDE() I/O
__Input__: parameters

PARAMETERS include: 
| Variable  | Description |
|-----------|------------|
| length1   | *Length in LICs 0, 7, 12*  |
| radius1   | *Radius in LICs 1, 8, 13*  |
| epsilon   | *Deviation from PI in LICs 2, 9*  |
| area1     | *Area in LICs 3, 10, 14*  |
| q_pts     | *Consecutive points in LIC 4*  |
| quads     | *Quadrants in LIC 4*  |
| dist      | *Distance in LIC 6*  |
| n_pts     | *Consecutive pts. in LIC 6*  |
| k_pts     | *LICs 7, 12*  |
| a_pts     | *LICs 8, 13*  |
| b_pts     | *LICs 8, 13*  |
| c_pts     | *LIC 9*  |
| d_pts     | *LIC 9*  |
| e_pts     | *LICs 10, 14*  |
| f_pts     | *LICs 10, 14*  |
| g_pts     | *LIC 11*  |
| length2   | *Maximum length in LIC 12*  |
| radius2   | *Maximum radius in LIC 13*  |
| area2     | *Maximum area in LIC 14*  |



The rest are global variables:
- NUMPOINTS The number of planar data points.
- X and Y Arrays containing the coordinates of data points.
- LCM Logical Connector Matrix.
- PUV Preliminary Unlocking Vector.


__Output__: Final launch decision "YES" or "NO".

## What it does
This program determines whether an interceptor should be launched based on radar tracking data. The data is used to evaluate 15 prefedined Launch Interceptor Conditions (LICs), which analyzes geometric properties.

        
The decision-making process follows these steps:
1. Generate the Conditions Met Vector (CMV) - *Based on the 15 LIC evaluations and the results are stored in a boolean vector.*
2. Compute the Preliminary Unlocking Matrix (PUM) – *Determines whether combined conditions of LCM and CMV are satisfied.*
3. Generate the Final Unlocking Vector (FUV) – *Checks PUM and PUV conditions which are required for launch.*
4. Make the Final Decision with launch() – *If all required conditions in FUV are met, launch() returns the final boolean decisition. The final decition is made from launch, the program outputs "YES" (true - launch) or "NO" (false - no launch).*

## Rights to use it
__Copyright <2025> <Group 2>__

__Permissions:__ private use, modification.

__Conditions:__ license and copyright notice.

__Limitations:__ liability and warranty.


## Essence Standard Evaluation

## Statement of Contributions
- __Jacob Lindström Bjäreklint__ - Implemented PUM(), con 5, 9, 10, 11, along with the corresponding unit tests. Also added error handling to CMV() and unit tests for the method.
- __Roger Chen__ - Implemented DECIDE() structure, con 7, 8, 12, 13, 14 with corresponding unit tests and implemented Parameters class.
- __Joline Frisk__ -Implemented CMV conditons 0, 1, 2, 3, and 4 along with corresponding unit test. As well as extra functions for calculations in other conditions methods.
- __Victoria Hellström__ - Implemented FUV(), launch() in Main.java and vectorProjection() and conditionSix() for LIC in ConditionsMet.java. Created unit tests for these and wrote the README file.
