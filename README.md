# Matrix Solver - Gauss-Jordan Method

Matrix Solver is a Java project designed to solve systems of linear equations using the Gauss-Jordan elimination method. Built with a strong focus on object-oriented programming (OOP) principles, the project aims to serve as a robust learning platform for mastering Java, numerical methods, and clean architecture.

---

## 🛠️ Getting Started

To run this project locally:

1. **Clone the repository**

```bash
git clone https://github.com/amitdev/MatrixSolver.git
cd MatrixSolver

---
```

## 🚀 Features

- Solve any system of linear equations
- Supports infinite solution representation using symbolic parameters (e.g., `t1`, `t2`, or `λ`, `μ`)
- Gauss-Jordan elimination implementation with full pivot support
- Beautiful, minimal output formatting for matrices and solutions
- Automatically simplifies results:
  - Whole numbers shown without decimal
  - Up to 3 digits after decimal if needed
- Designed with extendability in mind (interfaces, utility classes, clean structure)

---

## 📦 Project Structure

```text
src/
 ├── Main.java                  // Entry point, user interaction
 ├── Matrix.java                // Core matrix logic
 ├── MatrixInputHandler.java    // User input and matrix construction
 ├── MatrixSolver.java          // Gauss-Jordan algorithm
 ├── SolutionFormatter.java     // Handles pretty printing of the solution set
 └── utils/
```

---

## 🔍 Symbolic Parametric Solutions

If a system has infinitely many solutions, the solver will:

- Identify free variables
- Represent the solution in vector form:

```text
S = { (x1, x2, x3) | t1 in ℝ }
```

Or with Greek symbols (optional future toggle):

```text
S = { (x1, x2, x3) | λ in ℝ, μ in ℝ }
```

Where the solution is displayed using expressions like:

```text
x1 = 2 - t1
x2 = t1
x3 = 3
```

Free variable naming is clean and customizable (`t0`, `t1`, `λ`, etc).

---

## 🧪 Example Usage

### Input:

```text
Enter 2x3 matrix:
1 1 2
2 2 4
```

### Output:

```text
the matrix after row echelon by gauss jordan
1.000   1.000   2.000
0.000   0.000   0.000

S = { (2 - 1*t1, t1) | t1 in ℝ }
```

---

## 🔧 Future Improvements

- [ ] Matrix input via GUI (JavaFX)
- [ ] Export matrix/solution to CSV/JSON
- [ ] Support for LU Decomposition and modular arithmetic
- [ ] Add tests (JUnit) for validation and coverage
- [ ] Add complex number parser (e.g., `3+2i` input format)
- [ ] Toggle between parameter styles (`t1`, `λ`, etc)

---

## 🤝 Contributing

This is a personal learning project, but contributions and suggestions are welcome. Fork the repo, make a change, and let me know what you've learned!

---

## 🧠 Why This Project?

Because i'm on a mission to become the **#1 developer in the world** — and it starts by mastering the fundamentals the right way: with depth, clarity, and creativity.

---

## 🗂 License

This project is released under the MIT License.
