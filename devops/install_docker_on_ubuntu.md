# How to Install Docker on Ubuntu

[Index](index_en.md)

(2025.03.18)

Docker is a popular platform for containerizing applications, making it easy to build, ship, and run software in isolated environments. This guide walks you through installing Docker on Ubuntu, troubleshooting common issues, and configuring it for use in restricted network environments like China.

## Prerequisites

- An Ubuntu system (tested on Ubuntu 24.04).
- A user with `sudo` privileges.
- Internet access (with optional proxy or mirror configuration if needed).

## Step 1: Check if Docker is Installed

Before installing Docker, check if it’s already on your system:

```bash
docker --version
```

If Docker is not installed, you'll see something like this:

```bash
$ docker --version
Command 'docker' not found, but can be installed with:
sudo snap install docker         # version 27.5.1, or
sudo apt  install docker.io      # version 26.1.3-0ubuntu1~24.04.1
sudo apt  install podman-docker  # version 4.9.3+ds1-1ubuntu0.2
See 'snap info docker' for additional versions.
```

This output suggests three installation options. For this guide, we’ll use `docker.io` via `apt`, as it’s widely supported and stable.


## Step 2: Install Docker

Install Docker with the following command:

```bash
$ sudo apt update
$ sudo apt install docker.io -y
```

Verify the installation:

```bash
$ docker --version
Docker version 26.1.3, build 26.1.3-0ubuntu1~24.04.1
```

## Step 3: Test Docker with `hello-world`:

Run a simple test container:

```bash
$ docker run hello-world
```

If you encounter a permission error like this:

```plaintext
docker: permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Head "http://%2Fvar%2Frun%2Fdocker.sock/_ping": dial unix /var/run/docker.sock: connect: permission denied.
See 'docker run --help'.
```

It means your user lacks permission to access the Docker daemon. Fix this by adding your user to the `docker` group:

```bash
$ sudo usermod -aG docker $USER
$ newgrp docker
```

- `usermod -aG docker $USER`: Adds your current user to the `docker` group.
- `newgrp docker`: Activates the group change in your current session (alternatively, log out and back in).


Verify group membership:

```bash
$ groups
```

or

```bash
$ id
```

You should see `docker` in the list.

## Step 4: Fix Network Issues (e.g., in China)

Rerun the test:

```bash
$ docker run hello-world
```

If you’re in a region like China, where the Great Firewall (GFW) blocks Docker Hub (`registry-1.docker.io`), you might see:

```plaintext
Unable to find image 'hello-world:latest' locally
docker: Error response from daemon: Get "https://registry-1.docker.io/v2/": net/http: request canceled while waiting for connection (Client.Timeout exceeded while awaiting headers).
See 'docker run --help'.
```

Since I'm in China and the Great Firewall (GFW) restricts access to Docker Hub (registry-1.docker.io), pulling Docker images directly from Docker Hub can be slow, unreliable, or completely blocked. To bypass this, I have to configure Docker to use a local or regional Docker registry mirror within China.

To resolve this, configure Docker to use a registry mirror within China. Edit (or create) the Docker configuration file:

Open `/etc/docker/daemon.json` with `root` permission:

```bash
$ sudo vim /etc/docker/daemon.json
```

Add the following, using a few reliable mirrors (full list [here](https://github.com/dongyubin/DockerHub)):

```json
{
  "registry-mirrors": [
    "https://docker.zhai.cm",
    "https://a.ussh.net",
    "https://hub.littlediary.cn",
    "https://hub.rat.dev",
    "https://atomhub.openatom.cn",
    "https://docker.m.daocloud.io",
    "https://docker.1ms.run",
    "https://dytt.online",
    "https://func.ink",
    "https://lispy.org",
    "https://docker.xiaogenban1993.com",
    "https://docker.mybacc.com",
    "https://docker.yomansunter.com",
    "https://dockerhub.websoft9.com"
  ]
}
```

Then reload and restart Docker:

```bash
sudo systemctl daemon-reload
sudo systemctl restart docker
```

Test `hello-world` Again:

```bash
$ docker run hello-world
Unable to find image 'hello-world:latest' locally
latest: Pulling from library/hello-world
e6590344b1a5: Pull complete
Digest: sha256:7e1a4e2d11e2ac7a8c3f768d4166c2defeb09d2a750b010412b6ea13de1efb19
Status: Downloaded newer image for hello-world:latest

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/
```

Success! Docker is now installed and functional.

## Optional: Advanced Configuration

We can edit `/etc/docker/daemon.json` to configure others, e.g.

- set a proxy: Useful if you’re behind a corporate or regional proxy.
- enable `experimental`
- set log options

```json
{
    "proxies": {
      "http-proxy": "http://192.168.1.1:8899",
      "https-proxy": "http://192.168.1.1:8899",
      "no-proxy": "localhost,127.0.0.0/8,172.0.0.0/8,192.0.0.0/8"
    },
    "experimental" : true,
    "log-opts": {
      "max-size": "512m",
      "max-file": "5"
    }
}
```

<script src="https://giscus.app/client.js"
        data-repo="iridiumcao/iridiumcao.github.io"
        data-repo-id="MDEwOlJlcG9zaXRvcnkyOTUwNTIyODQ="
        data-category="Announcements"
        data-category-id="DIC_kwDOEZYj_M4Cxfqj"
        data-mapping="pathname"
        data-strict="0"
        data-reactions-enabled="1"
        data-emit-metadata="0"
        data-input-position="bottom"
        data-theme="preferred_color_scheme"
        data-lang="en"
        crossorigin="anonymous"
        async>
</script>