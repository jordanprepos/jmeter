# JMeter API Testing Suite

A comprehensive API testing framework built on Apache JMeter. This repository contains test plans (`.jmx`) designed for functional, integration, and security testing of open banking and financial services APIs, moving beyond simple performance testing.

The suite currently covers core transactional systems, including **QRIS CPM**, **Cobrand Savings**, and **Firm Banking** (including standalone transfers).

---

## 🎯 Project Goal

The primary goal of this project is to leverage **Apache JMeter as a robust API automation and validation tool**. Rather than focusing solely on load/performance metrics, these scripts:
- Perform end-to-end API functional testing (e.g., token acquisition -> transaction -> query status).
- Validate complex signature/encryption requirements (e.g., B2B signatures, customer auth tokens).
- Assert expected response codes and structures matching official API specifications.
- Serve as repeatable integration/regression tests for SIT (System Integration Testing) and UAT (User Acceptance Testing) environments.

---

## 📂 Project Structure

The project test plans currently pushed to the main branch are structured inside the `JMX/` folder:

* **`JMX/CPM/`**: transactions example:
  * `Test.jmx`
  * `Test 2.jmx`
 

---

## 📊 Example Execution Results

Real-world execution logs, validation traces, and response payloads are captured in the [testing-result/](file:///Users/jordan/Desktop/JMX/apache-jmeter/testing-result) directory. These logs provide concrete proof of test runs across different environments:


---

## 🚀 How to Run the Tests

You can run these scripts using the local Apache JMeter installation included in this repository.

### Prerequisites
Make sure Java 1.8 (Java 8) is installed on your system.

### Running via GUI Mode
For building, editing, or debugging tests:
```bash
./bin/jmeter
```
Once the GUI starts, open any `.jmx` file from the `JMX/` folder (e.g., `File > Open > JMX/CPM/QR CPM - AJ.jmx`).

### Running via CLI (Non-GUI Mode)
To run automated test suites and output results to a log file:
```bash
./bin/jmeter -n -t "JMX/CPM/QR CPM - AJ.jmx" -l "testing-result/run_result.jtl"
```

---

## 🛠️ Built-in JMeter Version
This project repository is packaged with a precompiled installation of **Apache JMeter 5.5** (managed under the `bin` and `libexec` directories).
