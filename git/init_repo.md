# How to Create a New Repository

[Index](index.md)

To create a new repository, you can follow these steps:

## Bare Repository (on Server Host)

Set up a repository on the server host by running the following command:

```plaintext
git init helloworld.git --bare
```

Alternatively, you can use the following commands:

```plaintext
mkdir helloworld.git
cd helloworld.git
git init --bare
```

A bare repository is typically named as "repo_name.git".

## Local Repository (as Client)

Create a repository as a workspace on your local machine by running the following command:

```plaintext
git init helloworld
```

Alternatively, you can use the following commands:

```plaintext
mkdir helloworld
cd helloworld
git init
```

By following these steps, you can create a new repository either on the server host or on your local machine.
