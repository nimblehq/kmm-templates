// DO NOT MODIFY
// Automatically generated by Arkana (https://github.com/rogerluan/arkana)

import Foundation
import ArkanaKeysInterfaces

public enum ArkanaKeys {
    @inline(__always)
    fileprivate static let salt: [UInt8] = [
        0xdb, 0x37, 0x91, 0x63, 0xc5, 0x58, 0xfd, 0x56, 0xca, 0x57, 0x6e, 0x7f, 0xdd, 0x75, 0x7f, 0xf2, 0x3f, 0x1d, 0xc2, 0x69, 0xa0, 0x1b, 0x2f, 0xa1, 0xc8, 0xe5, 0x4d, 0xc2, 0xe9, 0x3b, 0x73, 0x35, 0xb8, 0xb4, 0x1d, 0x3d, 0xb8, 0x29, 0xb2, 0xf2, 0xd5, 0x1e, 0x2c, 0x65, 0xb5, 0x97, 0xf, 0x19, 0x42, 0x77, 0xb7, 0x77, 0x55, 0xa9, 0xa0, 0x78, 0xa5, 0xe1, 0x34, 0x19, 0x7c, 0x38, 0x53, 0xaa
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
