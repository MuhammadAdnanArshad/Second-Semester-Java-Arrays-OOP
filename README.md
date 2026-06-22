# Second-Semester-Java-Arrays-OOP
A modular Java system for processing environmental sensor datasets, detecting pollution anomalies, and routing automated safety alerts.
# Smart City Air Quality Monitoring System

Welcome to my Java development repository! This project implements a modular, array-based analytical backend built during my 2nd semester of Software Engineering. It simulates an environmental tracking system that processes streaming sensor data to audit air quality and identify hazardous environmental conditions.

## Key Topics Covered

* **Array-Driven Analysis:** Processing data values sequentially in memory and capturing target index positions dynamically.
* **Modular Engineering:** Restructuring logic into isolated static methods with zero-fault handling loops.
* **Algorithmic Filtering:** Evaluating multi-conditioned logical variables to pinpoint sudden data spikes (surges).

## Featured Core Module

This repository centers on a standalone analytical engine:

* **SmartCityAirQualityMonitoringSystem.java** - Ingests continuous floating-point AQI values, parses immediate neighboring readings to isolate verified pollution surges ($\geq 15$ units variance), runs categorization pipelines, and dispatches relative alerts.

## How to Run This Program

1. Open your terminal environment inside the project directory.
2. Compile the source file:
   ```bash
   javac SmartCityAirQualityMonitoringSystem.java
   ```
3. Execute the compiled application layer:
   ```bash
   java SmartCityAirQualityMonitoringSystem
   ```

## About Me

I am a 2nd-semester Software Engineering student focusing on algorithmic development, backend architectures, and secure data processing logic. This codebase serves as an application checkpoint on my roadmap toward Cloud & Infrastructure Engineering! 🚀
