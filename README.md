# Thread Weaver Demo

## Repository Description

This repository contains some simple demo and examples of [Thread Weaver](https://github.com/jankotek/thread-weaver) that is being used in the presentation of [KTH DevOps Course](https://github.com/KTH/devops-course) 2022.

Presentation topic: **Automated testing of Java concurrent programs with Thread Weaver**

## Requirements

 - Java 8

## File Description

### `DeadlockExample.java`

This is an example that demonstrate a typical deadlock problem in a concurrent program.

### `BadAccount.java`

This is an example that demonstrate a typical race condition problem in a concurrent program.

#### `BadAccountTest.java`

A stress test that is usually used to test a concurrent program.

#### `BadAccountwithThreadWeaverTest.java`

A example that uses Thread Weaver to test a concurrent program.