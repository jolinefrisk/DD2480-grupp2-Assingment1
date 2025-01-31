# DECIDE() program
Group 2

Assignment 1

## Purpose
The DECIDE() function determines if an interceptor should be launched based upon input radar tracking information. The DECIDE() function is a part of a hypothetical anti-ballistic missile system called the Launch Interceptor Program.

## DECIDE() I/O
__Input__: 

__Output__: Final launch decision "YES" or "NO".

## What it does
This program determines whether an interceptor should be launched based on radar tracking data. It processes up planar radar data points and evaluates 15 predefined Launch Interceptor Conditions (LICs). These conditions analyze geometric properties of the data, such as distances, angles, and areas.

The decision-making process follows these steps:
1. Generate the Conditions Met Vector (CMV) from the 15 LIC evalutions – Stores the true/false results in a matrix.
2. Apply Logical Connector Matrix (LCM) – Defines how conditions should be combined.
3. Compute the Preliminary Unlocking Matrix (PUM) – Determines whether combined conditions are satisfied.
4. Generate the Final Unlocking Vector (FUV) – Checks PUM and PUV conditions which are required for launch.
5. Make the Final Decision with launch() – If all required conditions in FUV are met, launch() returns the final boolean decisition. The final decition is made from launch, the program outputs "YES" (true - launch) or "NO" (false - no launch).

## Rights to use it
__Copyright <2025> <Group 2>__

__Permissions:__ private use, modification.

__Conditions:__ license and copyright notice.

__Limitations:__ liability and warranty.


## Essence Standard Evaluation

## Statement of Contributions
- Jacob Lindström Bjäreklint - Implemented PUM(), con 5, 9, 10, 11, along with the corresponding unit tests. Also added error handling to CMV() and unit tests for the method.
- Roger Chen
- Joline Frisk
- Victoria Hellström - FUV(), launch(), con6 in LIC, tests, README
