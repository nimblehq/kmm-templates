// DO NOT MODIFY
// Automatically generated by Arkana (https://github.com/rogerluan/arkana)

import Foundation
import ArkanaKeysInterfaces

public enum ArkanaKeys {
    @inline(__always)
    fileprivate static let salt: [UInt8] = [
        0xf8, 0x68, 0x3e, 0x2e, 0x5d, 0x8a, 0xc4, 0x5f, 0xb6, 0xa7, 0xc0, 0xa0, 0x51, 0x52, 0x28, 0xb9, 0x5a, 0x7d, 0x26, 0xb0, 0xd4, 0x92, 0x77, 0xc0, 0xfd, 0xed, 0x8c, 0x98, 0x91, 0x58, 0x3b, 0xb5, 0xe6, 0xcc, 0x4f, 0x45, 0xff, 0xd1, 0xf7, 0xb, 0xec, 0x42, 0x6a, 0xb, 0xdb, 0xae, 0xf9, 0xda, 0x28, 0x65, 0x8b, 0xbf, 0xcb, 0x84, 0x54, 0x10, 0x8a, 0xc0, 0x13, 0x17, 0xaf, 0x4d, 0xf5, 0xbf
    ]

    static func decode(encoded: [UInt8], cipher: [UInt8]) -> String {
        return String(decoding: encoded.enumerated().map { offset, element in
            element ^ cipher[offset % cipher.count]
        }, as: UTF8.self)
    }

    static func decode(encoded: [UInt8], cipher: [UInt8]) -> Bool {
        let stringValue: String = Self.decode(encoded: encoded, cipher: cipher)
        return Bool(stringValue)!
    }

    static func decode(encoded: [UInt8], cipher: [UInt8]) -> Int {
        let stringValue: String = Self.decode(encoded: encoded, cipher: cipher)
        return Int(stringValue)!
    }
}

public extension ArkanaKeys {
    struct Global: ArkanaKeysGlobalProtocol {
        public init() {}
    }
}

public extension ArkanaKeys {
    struct Staging: ArkanaKeysEnvironmentProtocol {
        public init() {}
    }
}
public extension ArkanaKeys {
    struct Release: ArkanaKeysEnvironmentProtocol {
        public init() {}
    }
}
