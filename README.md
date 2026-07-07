# JMeter API Testing Suite

A comprehensive API testing framework built on Apache JMeter. This repository contains test plans (`.jmx`) designed for functional, integration, and security testing of open banking and financial services APIs, moving beyond simple performance testing.

The suite covers various transactional systems, including **SNAP Open API specs**, **BI-Fast** (transfers, inquiries), **QRIS MPM**, and **Cobrand Services** (Savings, E-money, Direct Debit).

---

## 🎯 Project Goal

The primary goal of this project is to leverage **Apache JMeter as a robust API automation and validation tool**. Rather than focusing solely on load/performance metrics, these scripts:
- Perform end-to-end API functional testing (e.g., token acquisition -> transaction -> query status).
- Validate complex signature/encryption requirements (e.g., B2B signatures, customer auth tokens).
- Assert expected response codes and structures matching official API specifications.
- Serve as repeatable integration/regression tests for SIT (System Integration Testing) and UAT (User Acceptance Testing) environments.

---

## 📂 Project Structure

The project test plans are structured inside the `JMX/` folder:

- **`JMX/CPM/`**: Consumer Presented Mode QR transactions (Generate QR, Payment, Query, Refund, Cancel, Batam QRIS).
- **`JMX/Cobrand Savings/`**: Cobrand Savings account operations (Account creation, balance inquiries, BI-Fast, Direct Debit, QRIS MPM).
- **`JMX/Firm Banking/`**: Firm Banking operations (Balance inquiries, bank statements, Standalone Interbank & Intrabank transfers).
- **`JMX/BI FAST/`**: BI-Fast system integration test plans.
- **`JMX/QRIS/`**: QRIS issuer, acquirer, and CICO (Cash-In/Cash-Out) scripts.
- **`JMX/Virtual Account/`**: Virtual Account payment and inquiry scenarios.

---

## 📊 Example Execution Results

Real-world execution logs, validation traces, and response payloads are captured in the [testing-result/](file:///Users/jordan/Desktop/JMX/apache-jmeter/testing-result) directory. These logs provide concrete proof of test runs across different environments (DEV, SIT, SANDBOX).

For example:
- **Execution Log Trace**: [testing-result/Cobrand/DEV - OAB-73.txt](file:///Users/jordan/Desktop/JMX/apache-jmeter/testing-result/Cobrand/DEV%20-%20OAB-73.txt) shows the detailed HTTP request headers, signatures, payloads, and corresponding success responses for:
  - B2B Oauth token generation (`/api/oauth/token`)
  - B2B2C Access Token request (`/v1.0/access-token/b2b2c/`)
  - QR MPM dynamic generation (`/v1.0/qr/qr-mpm-generate/`)
  - QR MPM dynamic payment decode (`/v1.0/qr/qr-mpm-decode/cobrand/`)

---

## 🚀 How to Run the Tests

You can run these scripts using the local Apache JMeter installation included in this repository.

### Prerequisites
Make sure Java 8 or higher is installed on your system.

### Running via GUI Mode
For building, editing, or debugging tests:
```bash
./bin/jmeter
```
Once the GUI starts, open any `.jmx` file from the `JMX/` folder (e.g., `File > Open > JMX/CPM/QR CPM - AJ.jmx`).

### Running via CLI (Non-GUI Mode)
To run automated test suites and output results to a log file:
```bash
./bin/jmeter -n -t "JMX/CPM/QR CPM - AJ.jmx" -l "testing-result/CPM/run_result.jtl"
```

---

## 🛠️ Built-in JMeter Version
This project repository is packaged with a precompiled installation of **Apache JMeter 5.5** (managed under the `bin` and `libexec` directories).
