# Java Keytool Guide

[Index](index_en.md)

The Java `keytool` is a command-line utility bundled with the Java Development Kit (JDK) for managing cryptographic keys and certificates. It is located in `{JAVA_HOME}/bin/`. While it doesn’t manage SSH certificates directly (SSH uses a different mechanism), it is commonly used to handle Java keystores, such as the default `cacerts` file located at `{JAVA_HOME}/lib/security/cacerts`. This guide covers common `keytool` operations like listing, importing, exporting, and deleting certificates.

`keytool` isn’t as widely recognized as `java` or `javac`, and in most cases, it doesn’t require much attention. However, it can be essential in certain situations. For example, when connecting to a private Maven server (e.g., Sonatype Nexus Repository) over HTTPS, you need to import the HTTPS certificate into the JDK.

> **Note**: The default password for the `cacerts` keystore is `"changeit"`. Adjust commands accordingly if your keystore uses a different password.

## Listing Certificates

```bash
# List all certificates in the keystore (default password: "changeit")
keytool -list -keystore ${JAVA_HOME}/lib/security/cacerts

# List all certificates with detailed information (default password: "changeit")
keytool -list -v -keystore ${JAVA_HOME}/lib/security/cacerts

# List details of a specific certificate by alias (default password: "changeit")
keytool -list -v -alias ${demo_name} -keystore ${JAVA_HOME}/lib/security/cacerts

# List details of a specific certificate by alias, specifying the password in the command
keytool -list -v -alias ${demo_name} -keystore ${JAVA_HOME}/lib/security/cacerts -storepass changeit -noprompt
```

- `-list`: Lists the certificates in the keystore.
- `-keystore {file}`: Specifies the keystore file path.
- `-v`: Displays detailed certificate information.
- `-alias {name}`: Filters the list to show only the specified certificate.
- `-storepass {password}`: Specifies the keystore password.
- `-noprompt`: Suppresses prompts for user input.

**Note**: When running the command in PowerShell, wrap parameters in quotes. Example:

```PowerShell
.\keytool.exe -list -keystore "..\lib\security\cacerts" -storepass changeit
```

## Importing a Certificate

```bash
# Import a certificate into the keystore
keytool -importcert -file ${cert_path} -alias ${cert_alias} -keystore ${JAVA_HOME}/lib/security/cacerts -storepass changeit -noprompt
```

- `-file <path>`: Path to the certificate file (e.g., .crt or .pem).
- `-alias <name>`: Assigns a unique name to the imported certificate.

## Exporting a Certificate

To extract a certificate from the keystore, use `-exportcert` with `-alias`, e.g:

```PowerShell
# Export a certificate from the keystore
.\keytool.exe -exportcert -alias "hello" -keystore "..\lib\security\cacerts" -file outputhello -storepass changeit
```

## Deleting a Certificate

To remove a certificate from the keystore, use the `-delete` command:

```bash
# Delete a certificate from the keystore (default password: "changeit")
keytool -delete -alias ${cert_alias} -keystore ${JAVA_HOME}/lib/security/cacerts
```

## Getting Help

For more information on keytool commands and options:

```bash
# Display general help
keytool --help

# Get help for a specific command (e.g., exportcert)
keytool -exportcert --help
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
