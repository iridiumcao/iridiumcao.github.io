# IPSF Help Document

```text
$ ipfs --help
USAGE
  ipfs  - Global p2p merkle-dag filesystem.

SYNOPSIS
  ipfs [--config=<config> | -c] [--debug | -D] [--help] [-h] [--api=<api>] [--offline] [--cid-base=<base>] [--upgrade-cidv0-in-output] [--encoding=<encoding> | --enc] [--timeout=<timeout>] <command> ...

OPTIONS

  -c, --config               string - Path to the configuration file to use.
  -D, --debug                bool   - Operate in debug mode.
  --help                     bool   - Show the full command help text.
  -h                         bool   - Show a short version of the command help
                                      text.
  -L, --local                bool   - Run the command locally, instead of using
                                      the daemon. DEPRECATED: use --offline.
  --offline                  bool   - Run the command offline.
  --api                      string - Use a specific API instance (defaults to
                                      /ip4/127.0.0.1/tcp/5001).
  --cid-base                 string - Multibase encoding used for version 1
                                      CIDs in output.
  --upgrade-cidv0-in-output  bool   - Upgrade version 0 to version 1 CIDs in
                                      output.
  --enc, --encoding          string - The encoding type the output should be
                                      encoded with (json, xml, or text).
                                      Default: text.
  --stream-channels          bool   - Stream channel output.
  --timeout                  string - Set a global timeout on the command.

SUBCOMMANDS
  BASIC COMMANDS
    init          Initialize ipfs local configuration
    add <path>    Add a file to IPFS
    cat <ref>     Show IPFS object data
    get <ref>     Download IPFS objects
    ls <ref>      List links from an object
    refs <ref>    List hashes of links from an object
  
  DATA STRUCTURE COMMANDS
    block         Interact with raw blocks in the datastore
    object        Interact with raw dag nodes
    files         Interact with objects as if they were a unix filesystem
    dag           Interact with IPLD documents (experimental)
  
  ADVANCED COMMANDS
    daemon        Start a long-running daemon process
    mount         Mount an IPFS read-only mount point
    resolve       Resolve any type of name
    name          Publish and resolve IPNS names
    key           Create and list IPNS name keypairs
    dns           Resolve DNS links
    pin           Pin objects to local storage
    repo          Manipulate the IPFS repository
    stats         Various operational stats
    p2p           Libp2p stream mounting
    filestore     Manage the filestore (experimental)
  
  NETWORK COMMANDS
    id            Show info about IPFS peers
    bootstrap     Add or remove bootstrap peers
    swarm         Manage connections to the p2p network
    dht           Query the DHT for values or peers
    ping          Measure the latency of a connection
    diag          Print diagnostics
  
  TOOL COMMANDS
    config        Manage configuration
    version       Show ipfs version information
    update        Download and apply go-ipfs updates
    commands      List all available commands
    cid           Convert and discover properties of CIDs
    log           Manage and show logs of running daemon
  
  Use 'ipfs <command> --help' to learn more about each command.
  
  ipfs uses a repository in the local file system. By default, the repo is
  located at ~/.ipfs. To change the repo location, set the $IPFS_PATH
  environment variable:
  
    export IPFS_PATH=/path/to/ipfsrepo
  
  EXIT STATUS
  
  The CLI will exit with one of the following values:
  
  0     Successful execution.
  1     Failed executions.

  For more information about each command, use:
  'ipfs <subcmd> --help'

```