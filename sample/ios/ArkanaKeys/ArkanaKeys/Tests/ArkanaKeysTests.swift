// DO NOT MODIFY
// Automatically generated by Arkana (https://github.com/rogerluan/arkana)

import Foundation
import ArkanaKeysInterfaces
import XCTest
@testable import ArkanaKeys

final class ArkanaKeysTests: XCTestCase {
    private var salt: [UInt8]!
    private var globalSecrets: ArkanaKeysGlobalProtocol!

    override func setUp() {
        super.setUp()
        salt = [
            0xe1, 0x1e, 0xe3, 0x73, 0x8, 0x2, 0xc5, 0xda, 0x3, 0xc4, 0xc1, 0x22, 0x93, 0x5c, 0x77, 0xa1, 0x11, 0xb6, 0xe9, 0x84, 0xd1, 0xb, 0xc3, 0xc, 0x98, 0xfa, 0xe4, 0x9c, 0x5c, 0x23, 0x6d, 0x7, 0xe, 0x98, 0x71, 0xb4, 0x41, 0xaa, 0x94, 0x29, 0x9e, 0x88, 0x85, 0x62, 0x67, 0x7, 0xbe, 0x93, 0xf6, 0xb8, 0xd7, 0x5f, 0xb5, 0xa0, 0x7a, 0xa0, 0x80, 0x34, 0x3a, 0x54, 0xe9, 0xa5, 0x8e, 0x69
        ]
        globalSecrets = ArkanaKeys.Global()
    }

    override func tearDown() {
        globalSecrets = nil
        salt = nil
        super.tearDown()
    }

    func test_decodeRandomHexKey_shouldDecode() {
        let encoded: [UInt8] = [
            0xd6, 0x78, 0xd0, 0x11, 0x38, 0x32, 0xf5, 0xed, 0x36, 0xf2, 0xf6, 0x44, 0xf5, 0x6b, 0x43, 0xc2, 0x20, 0x87, 0xd9, 0xe5, 0xe1, 0x3c, 0xf4, 0x3a, 0xab, 0xc8, 0x82, 0xa5, 0x68, 0x46, 0x8, 0x37, 0x3e, 0xa9, 0x46, 0xd1, 0x79, 0x9e, 0xf7, 0x48, 0xfd, 0xba, 0xe1, 0x52, 0x57, 0x35, 0x8b, 0xa7, 0xcf, 0x89, 0xe4, 0x6c, 0xd3, 0xc2, 0x4b, 0x94, 0xb7, 0x2, 0x8, 0x64, 0xdb, 0x9d, 0xb6, 0x59, 0xd5, 0x29, 0x80, 0x11, 0x6b, 0x67, 0xf7, 0xec, 0x32, 0xf3, 0xf8, 0x44, 0xa6, 0x68, 0x16, 0x92, 0x27, 0x84, 0x8c, 0xb4, 0xb7, 0x69, 0xa1, 0x3e, 0xaf, 0xc3, 0xdc, 0xfa, 0x38, 0x46, 0x9, 0x34, 0x6d, 0xfc, 0x10, 0x8d, 0x24, 0xc8, 0xf5, 0x10, 0xac, 0xed, 0xb5, 0x5a, 0x1, 0x34, 0x8f, 0xa5, 0xce, 0x80, 0xe7, 0x69, 0xd1, 0x96, 0x1b, 0x94, 0xe1, 0x5, 0x59, 0x35, 0x8d, 0x94, 0xef, 0x5a
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), "7f3b0007567ff74c110a077632f94ee0017e84cac2d002549133fb147620288047cbce26179f54a362e0fbb2798fded3cda9eba92e08f3168806d6a4a1cad1a3")
    }

    func test_decodeRandomBase64Key_shouldDecode() {
        let encoded: [UInt8] = [
            0xa6, 0x73, 0x96, 0x43, 0x31, 0x60, 0xa2, 0x91, 0x6c, 0xa2, 0xb7, 0x65, 0xa3, 0x6f, 0x43, 0xcc, 0x5e, 0xdc, 0xbd, 0xfc, 0x83, 0x4c, 0x85, 0x41, 0xfb, 0x8d, 0xa0, 0xc4, 0x5, 0x8, 0xb, 0x4f, 0x7b, 0xe2, 0x28, 0xf8, 0x31, 0xc2, 0xc6, 0x7c, 0xf9, 0xe3, 0xf5, 0x25, 0x55, 0x60, 0x88, 0xab, 0x98, 0x8a, 0x9b, 0x36, 0xf3, 0x8b, 0x36, 0xd4, 0xf9, 0x65, 0x5c, 0x12, 0xb9, 0x96, 0xd8, 0x3, 0xb5, 0x2b, 0xa7, 0x1f, 0x67, 0x6c, 0x8b, 0xeb, 0x60, 0x93, 0x88, 0x5a, 0xdf, 0x65, 0x35, 0xe7, 0x27, 0x8e, 0xbe, 0xab, 0x9d, 0x6c, 0xfe, 0x31
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), "Gmu09bgKofvG034mOjTxRGFMcwDXY+fHuzYLphRUgkpG2g68n2LiF+LtyQfFP3VjT5DlonN1cWIxL9BF68W/Lg==")
    }

    func test_decodeUUIDKey_shouldDecode() {
        let encoded: [UInt8] = [
            0xd7, 0x29, 0xd5, 0x41, 0x30, 0x31, 0xfd, 0xee, 0x2e, 0xf4, 0xa7, 0x14, 0xa0, 0x71, 0x43, 0x94, 0x77, 0x87, 0xc4, 0xe6, 0xb5, 0x3f, 0xf6, 0x21, 0xfc, 0xca, 0xd3, 0xae, 0x3f, 0x17, 0x55, 0x33, 0x6f, 0xac, 0x10, 0x8d
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), "67628384-0f63-45f1-bd45-d072c484a4a9")
    }

    func test_decodeTrueBoolValue_shouldDecode() {
        let encoded: [UInt8] = [
            0x95, 0x6c, 0x96, 0x16
        ]
        XCTAssertTrue(ArkanaKeys.decode(encoded: encoded, cipher: salt))
    }

    func test_decodeFalseBoolValue_shouldDecode() {
        let encoded: [UInt8] = [
            0x87, 0x7f, 0x8f, 0, 0x6d
        ]
        XCTAssertFalse(ArkanaKeys.decode(encoded: encoded, cipher: salt))
    }

    func test_decodeIntValue_shouldDecode() {
        let encoded: [UInt8] = [
            0xd5, 0x2c
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), 42)
    }

    func test_encodeAndDecodeValueWithDollarSign_shouldDecode() {
        let encoded: [UInt8] = [
            0x93, 0x7b, 0x82, 0x1f, 0x57, 0x26, 0xa9, 0xb3, 0x6e, 0x9b, 0xb2, 0x4a, 0xf2, 0x38, 0xe
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), "real_$lim_shady")
    }
}
