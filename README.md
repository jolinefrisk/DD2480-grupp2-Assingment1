# DECIDE() program
Group 2

Assignment 1

## Purpose
The DECIDE() function determines if an interceptor should be launched based upon input radar tracking information. The DECIDE() function is a part of a hypothetical anti-ballistic missile system called the Launch Interceptor Program.

## DECIDE() I/O
__Input__: 

__Output__: Final launch decision (boolean)

## What it does
This program determines whether an interceptor should be launched based on radar tracking data. It processes up planar radar data points and evaluates 15 predefined Launch Interceptor Conditions (LICs). These conditions analyze geometric properties of the data, such as distances, angles, and areas.

The decision-making process follows these steps:
1. Generate the Conditions Met Vector (CMV) from the 15 LIC evalutions – Stores the true/false results in a matrix.
2. Apply Logical Connector Matrix (LCM) – Defines how conditions should be combined.
3. Compute the Preliminary Unlocking Matrix (PUM) – Determines whether combined conditions are satisfied.
4. Generate the Final Unlocking Vector (FUV) – Checks which conditions are required for launch.
5. Make the Final Decision – If all required conditions are met, the program outputs "YES" (launch). Otherwise, it outputs "NO" (no launch).

## Rights to use it
Copyright <2025> <Group 2>
Permissions: private use, modification.
Conditions: license and copyright notice.
Limitations: liability and warranty.


## Essence standard evaluation
Property:  You have assessed and documented (in one paragraph) your way of working (p. 58 in the Essence standardLinks to an external site. v1.2) by evaluating the checklist on p. 60: In what state are you in? Why? What are obstacles to reach the next state?
Checklist:
1.  Principles Established
      - Established Principles and constraints are committed to by the team.
              - Our group established ground rules before working on DECIDE and agreed on the terms and constrains. Therefore the "Principles Established" in the checklist 
      - Principles and constraints are agreed to by the stakeholders.
      -       - 
      - The tool needs of the work and its stakeholders are agreed.
      - A recommendation for the approach to be taken is available.
      - The context within which the team will operate is understood.
      - The constraints that apply to the selection, acquisition, and use of practices and tools are known.
2. Foundation Established
      - The key practices and tools that form the foundation of the way-of-working are selected.
      - Enough practices for work to start are agreed to by the team.
      - All non-negotiable practices and tools have been identified.
      - The gaps that exist between the practices and tools that are needed and the practices and tools that are available have been analyzed and understood.
      - The capability gaps that exist between what is needed to execute the desired way of working and the capability levels of the team have been analyzed and understood.
      - The selected practices and tools have been integrated to form a usable way-of-working.
3. In Use
      - The practices and tools are being used to do real work.
      - The use of the practices and tools selected are regularly inspected.
      - The practices and tools are being adapted to the team’s context.
      - The use of the practices and tools is supported by the team.
      - Procedures are in place to handle feedback on the team’s way of working.
      - The practices and tools support team communication and collaboration.
4. In Place 
      - The practices and tools are being used by the whole team to perform their work.
      - All team members have access to the practices and tools required to do their work.
      - The whole team is involved in the inspection and adaptation of the way-of-working.
5. Working well
      - Team members are making progress as planned by using and adapting the way-of working to suit their current context.
      - The team naturally applies the practices without thinking about them.
      - The tools naturally support the way that the team works.
      - The team continually tunes their use of the practices and tools.

## statement of contributions
- Jacob Lindström Bjäreklint
- Roger Chen
- Joline Frisk
- Victoria Hellström
