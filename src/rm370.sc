;;; Sierra Script 1.0 - (do not remove this comment)
(script# 370)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Feature)
(use Obj)

(public
	rm370 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 200]
	local205
	local206
)
(instance rm370 of Rm
	(properties
		picture 370
		horizon 54
	)
	
	(method (init)
		(Load rsVIEW (+ 706 global118))
		(Load rsVIEW (+ 702 global118))
		(Load rsVIEW (+ 704 global118))
		(Load rsVIEW (+ 700 global118))
		(if (gEgo has: 8)
			(Load rsVIEW (+ 703 global118))
			(Load rsVIEW 8)
		)
		(super init:)
		(if (> global87 16)
			(aMan1 init:)
			(aMan2 init:)
			(aMan3 init:)
		)
		(aLocker init:)
		(self setScript: RoomScript)
		(proc0_1)
		(cond 
			((== gGNumber 375) (gEgo loop: 2 posn: 221 58))
			((== gGNumber 380) (gEgo loop: 2 posn: 313 62))
			(else (= gGNumber_2 7) (gEgo posn: 307 179))
		)
		(gEgo
			view:
				(switch gGNumber_2
					(6 (+ 706 global118))
					(5 (+ 702 global118))
					(8 (+ 703 global118))
					(9 (+ 704 global118))
					(else  (+ 700 global118))
				)
			init:
		)
		(User canInput: 0 canControl: 1 mapKeyToDir: 1)
	)
	
	(method (newRoom newRoomNumber)
		(< (aLocker y?) 999)
		(if
			(and
				(== newRoomNumber 375)
				(== gGNumber_2 8)
				(gEgo has: 8)
			)
			(proc255_0 370 0 67 10 -1 70 290)
			(proc0_24 8 375)
			(= gGCursorNumber 900)
			(gGame setCursor: 998 (HaveMouse))
		)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(switch gGNumber_2
			(5
				(gEgo observeControl: 4096 8192 ignoreControl: 16384)
			)
			(6
				(gEgo observeControl: 4096 8192 ignoreControl: 16384)
			)
			(9
				(gEgo observeControl: 16384 4096 ignoreControl: 8192)
			)
			(8
				(gEgo observeControl: 8192 4096 ignoreControl: 16384)
			)
			(else 
				(gEgo observeControl: 8192 16384 ignoreControl: 4096)
			)
		)
		(if (& (gEgo onControl:) $0800) (gEgo setPri: 3))
		(if (& (gEgo onControl:) $0400) (gEgo setPri: -1))
		(cond 
			((& (gEgo onControl:) $0004) (global2 newRoom: 375))
			((& (gEgo onControl:) $0002)
				(if (not local3)
					(cond 
						((== gGNumber_2 7) (= local3 1) (proc255_0 370 1))
						((== gGNumber_2 9) (= local3 1) (proc255_0 370 2))
					)
				)
			)
			((& (gEgo onControl:) $0010) (global2 newRoom: 380))
			((& (gEgo onControl:) $0008)
				(if (not local3)
					(cond 
						((or (== gGNumber_2 5) (== gGNumber_2 6)) (= local3 1) (proc255_0 370 3))
						((== gGNumber_2 7)
							(= local3 1)
							(proc255_0 370 4)
							(if (not global118) (proc255_0 370 5 67 -1 144))
						)
						((== gGNumber_2 8) (= local3 1) (proc255_0 370 6))
					)
				)
			)
			((== 2 (gEgo edgeHit?))
				(= gGNumber_2 0)
				(= global66 (+ 700 global118))
				(global2 newRoom: 360)
			)
			((& (gEgo onControl:) $0020)
				(if (not local3)
					(cond 
						((or (== gGNumber_2 5) (== gGNumber_2 6)) (= local3 1) (proc255_0 370 7))
						((== gGNumber_2 9) (= local3 1) (proc255_0 370 8))
						((== gGNumber_2 8) (= local3 1) (proc255_0 370 9))
					)
				)
			)
			(else (= local3 0))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(proc0_3)
				(gEgo
					illegalBits: 0
					setPri:
					setLoop: 0
					setMotion: MoveTo (gEgo x?) (+ (gEgo y?) 20) self
				)
			)
			(2 (= seconds 2))
			(3
				(gEgo
					setMotion: MoveTo (gEgo x?) (- (gEgo y?) 20)
					view:
						(switch gGNumber_2
							(6 (+ 706 global118))
							(5 (+ 702 global118))
							(8 (+ 703 global118))
							(9 (+ 704 global118))
							(else  (+ 700 global118))
						)
				)
				(= cycles 22)
			)
			(4
				(proc255_0 @local5)
				(proc0_1 0 (gEgo view?))
			)
		)
	)
	
	(method (handleEvent pEvent)
		(asm
			pushi    #claimed
			pushi    0
			lap      pEvent
			send     4
			bnt      code_04ed
			ret     
code_04ed:
			pushi    1
			lofss    '/combination'
			callk    Said,  2
			bt       code_050c
			pushi    1
			lofss    'affirmative'
			callk    Said,  2
			bt       code_050c
			pushi    1
			lofss    'unbolt,use,open/locker,door'
			callk    Said,  2
			bnt      code_0620
code_050c:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			bnt      code_0524
			pushi    0
			callb    proc0_7,  0
			jmp      code_061d
code_0524:
			pushi    2
			pushi    370
			pushi    10
			calle    proc255_0,  4
code_0531:
			lsl      local0
			ldi      0
			le?     
			bnt      code_0547
			pushi    1
			lofss    {Primer N{mero:}
			calle    proc255_3,  2
			sal      local0
			jmp      code_0531
code_0547:
			lsl      local1
			ldi      0
			le?     
			bnt      code_055d
			pushi    1
			lofss    {Segundo N{mero:}
			calle    proc255_3,  2
			sal      local1
			jmp      code_0547
code_055d:
			lsl      local2
			ldi      0
			le?     
			bnt      code_0573
			pushi    1
			lofss    {Tercer N{mero:}
			calle    proc255_3,  2
			sal      local2
			jmp      code_055d
code_0573:
			pushi    6
			pushi    370
			pushi    11
			lsl      local0
			lsl      local0
			lsl      local1
			lsl      local2
			calle    proc255_4,  12
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_05a7
			pushi    2
			pushi    370
			pushi    12
			calle    proc255_0,  4
			jmp      code_0611
code_05a7:
			lsl      local0
			lag      global111
			ne?     
			bt       code_05bc
			lsl      local1
			lag      global112
			ne?     
			bt       code_05bc
			lsl      local2
			lag      global113
			ne?     
			bnt      code_05cb
code_05bc:
			pushi    2
			pushi    370
			pushi    13
			calle    proc255_0,  4
			jmp      code_0611
code_05cb:
			pushi    1
			pushi    40
			callb    proc0_22,  2
			not     
			bnt      code_05f6
			pushi    1
			pushi    40
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    100
			lag      gGame
			send     6
			pushi    2
			pushi    370
			pushi    14
			calle    proc255_0,  4
			jmp      code_0603
code_05f6:
			pushi    2
			pushi    370
			pushi    15
			calle    proc255_0,  4
code_0603:
			pushi    #posn
			pushi    2
			pushi    88
			pushi    65
			lofsa    aLocker
			send     8
code_0611:
			ldi      0
			sal      local0
			ldi      0
			sal      local1
			ldi      0
			sal      local2
code_061d:
			jmp      code_1de4
code_0620:
			pushi    1
			lofss    'unknownnumber/'
			callk    Said,  2
			bt       code_063e
			pushi    1
			lofss    '/unknownnumber'
			callk    Said,  2
			bt       code_063e
			pushi    1
			lofss    '//unknownnumber'
			callk    Said,  2
			bnt      code_064e
code_063e:
			pushi    2
			pushi    370
			pushi    16
			calle    proc255_0,  4
			jmp      code_1de4
code_064e:
			pushi    1
			lofss    'bolt,close/locker,door'
			callk    Said,  2
			bnt      code_069f
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_0670
			pushi    0
			callb    proc0_7,  0
			jmp      code_069c
code_0670:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_0687
			pushi    0
			callb    proc0_10,  0
			jmp      code_069c
code_0687:
			pushi    0
			callb    proc0_6,  0
			pushi    #posn
			pushi    2
			pushi    1111
			pushi    1111
			lofsa    aLocker
			send     8
code_069c:
			jmp      code_1de4
code_069f:
			pushi    1
			lofss    'drain,get/art'
			callk    Said,  2
			bnt      code_06cd
			pushi    2
			pushi    370
			pushi    17
			calle    proc255_0,  4
			pushi    5
			pushi    370
			pushi    18
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
			jmp      code_1de4
code_06cd:
			pushi    1
			lofss    'naked'
			callk    Said,  2
			bt       code_0700
			pushi    1
			lofss    'wear/nothing'
			callk    Said,  2
			bt       code_0700
			pushi    1
			lofss    'get/naked'
			callk    Said,  2
			bt       code_0700
			pushi    1
			lofss    'naked'
			callk    Said,  2
			bt       code_0700
			pushi    1
			lofss    '(alter<(out<of),from),(get<off),drain/cloth,towel,sweatpants,cloth'
			callk    Said,  2
			bnt      code_0786
code_0700:
			lsg      gGNumber_2
			ldi      5
			eq?     
			bt       code_070e
			lsg      gGNumber_2
			ldi      6
			eq?     
			bnt      code_071d
code_070e:
			pushi    2
			pushi    370
			pushi    19
			calle    proc255_0,  4
			jmp      code_0783
code_071d:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_073c
			pushi    2
			pushi    370
			pushi    20
			calle    proc255_0,  4
			jmp      code_0783
code_073c:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_075c
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_0783
code_075c:
			pushi    3
			lea      @local5
			push    
			pushi    370
			pushi    22
			callk    Format,  6
			lsg      global88
			ldi      3
			lt?     
			bnt      code_0777
			ldi      6
			sag      gGNumber_2
			jmp      code_077b
code_0777:
			ldi      5
			sag      gGNumber_2
code_077b:
			pushi    #changeState
			pushi    1
			pushi    1
			self     6
code_0783:
			jmp      code_1de4
code_0786:
			pushi    1
			lofss    'dress<get'
			callk    Said,  2
			bt       code_07a5
			pushi    1
			lofss    'get/dress'
			callk    Said,  2
			bt       code_07a5
			pushi    1
			lofss    'wear,get,(alter<in,to),(backdrop<on)/cloth[<leisure]'
			callk    Said,  2
			bnt      code_0848
code_07a5:
			lsg      gGNumber_2
			ldi      7
			eq?     
			bnt      code_07bc
			pushi    2
			pushi    370
			pushi    23
			calle    proc255_0,  4
			jmp      code_0845
code_07bc:
			pushi    1
			pushi    50
			callb    proc0_22,  2
			bnt      code_07d4
			pushi    2
			pushi    370
			pushi    24
			calle    proc255_0,  4
			jmp      code_0845
code_07d4:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_07f3
			pushi    2
			pushi    370
			pushi    25
			calle    proc255_0,  4
			jmp      code_0845
code_07f3:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_0813
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_0845
code_0813:
			pushi    1
			pushi    51
			callb    proc0_22,  2
			bnt      code_082b
			pushi    2
			pushi    370
			pushi    26
			calle    proc255_0,  4
			jmp      code_0845
code_082b:
			pushi    3
			lea      @local5
			push    
			pushi    370
			pushi    27
			callk    Format,  6
			ldi      7
			sag      gGNumber_2
			pushi    #changeState
			pushi    1
			pushi    1
			self     6
code_0845:
			jmp      code_1de4
code_0848:
			pushi    1
			lofss    'wear,get,(alter<in),(backdrop<on)/towel'
			callk    Said,  2
			bnt      code_08f3
			lsg      gGNumber_2
			ldi      8
			eq?     
			bnt      code_086a
			pushi    2
			pushi    370
			pushi    28
			calle    proc255_0,  4
			jmp      code_08f0
code_086a:
			pushi    #has
			pushi    1
			pushi    8
			lag      gEgo
			send     6
			not     
			bnt      code_087f
			pushi    0
			callb    proc0_12,  0
			jmp      code_08f0
code_087f:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_089e
			pushi    2
			pushi    370
			pushi    29
			calle    proc255_0,  4
			jmp      code_08f0
code_089e:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_08be
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_08f0
code_08be:
			pushi    1
			pushi    51
			callb    proc0_22,  2
			bnt      code_08d6
			pushi    2
			pushi    370
			pushi    26
			calle    proc255_0,  4
			jmp      code_08f0
code_08d6:
			pushi    3
			lea      @local5
			push    
			pushi    370
			pushi    30
			callk    Format,  6
			ldi      8
			sag      gGNumber_2
			pushi    #changeState
			pushi    1
			pushi    1
			self     6
code_08f0:
			jmp      code_1de4
code_08f3:
			pushi    1
			lofss    'wear,get,(alter<in),(backdrop<on)/sweatpants,(cloth<perspiration)'
			callk    Said,  2
			bnt      code_09be
			lsg      gGNumber_2
			ldi      9
			eq?     
			bnt      code_0915
			pushi    2
			pushi    370
			pushi    31
			calle    proc255_0,  4
			jmp      code_09bb
code_0915:
			pushi    1
			pushi    50
			callb    proc0_22,  2
			bnt      code_092e
			pushi    2
			pushi    370
			pushi    32
			calle    proc255_0,  4
			jmp      code_09bb
code_092e:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_094d
			pushi    2
			pushi    370
			pushi    25
			calle    proc255_0,  4
			jmp      code_09bb
code_094d:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_096d
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_09bb
code_096d:
			pushi    1
			pushi    51
			callb    proc0_22,  2
			bnt      code_0985
			pushi    2
			pushi    370
			pushi    26
			calle    proc255_0,  4
			jmp      code_09bb
code_0985:
			pushi    3
			lea      @local5
			push    
			pushi    370
			pushi    33
			callk    Format,  6
			ldi      9
			sag      gGNumber_2
			pushi    1
			pushi    41
			callb    proc0_22,  2
			not     
			bnt      code_09b3
			pushi    1
			pushi    41
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    4
			lag      gGame
			send     6
code_09b3:
			pushi    #changeState
			pushi    1
			pushi    1
			self     6
code_09bb:
			jmp      code_1de4
code_09be:
			pushi    1
			lofss    '(look<for),find/locker'
			callk    Said,  2
			bt       code_09d3
			pushi    1
			lofss    '(look<for),find//locker'
			callk    Said,  2
			bnt      code_0aa9
code_09d3:
			pushi    4
			pushi    #x
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #y
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    88
			pushi    65
			callk    GetDistance,  8
			sal      local4
			push    
			ldi      150
			gt?     
			bnt      code_0a07
			pushi    2
			pushi    370
			pushi    34
			calle    proc255_0,  4
			jmp      code_0aa6
code_0a07:
			lsl      local4
			ldi      80
			gt?     
			bnt      code_0a1e
			pushi    2
			pushi    370
			pushi    35
			calle    proc255_0,  4
			jmp      code_0aa6
code_0a1e:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      512
			and     
			bnt      code_0a3d
			pushi    2
			pushi    370
			pushi    36
			calle    proc255_0,  4
			jmp      code_0aa6
code_0a3d:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      256
			and     
			bnt      code_0a5c
			pushi    2
			pushi    370
			pushi    37
			calle    proc255_0,  4
			jmp      code_0aa6
code_0a5c:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      128
			and     
			bnt      code_0a7b
			pushi    2
			pushi    370
			pushi    38
			calle    proc255_0,  4
			jmp      code_0aa6
code_0a7b:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			bnt      code_0a99
			pushi    2
			pushi    370
			pushi    39
			calle    proc255_0,  4
			jmp      code_0aa6
code_0a99:
			pushi    2
			pushi    370
			pushi    40
			calle    proc255_0,  4
code_0aa6:
			jmp      code_1de4
code_0aa9:
			pushi    1
			lofss    'pick/bolt,locker'
			callk    Said,  2
			bnt      code_0ac3
			pushi    2
			pushi    370
			pushi    41
			calle    proc255_0,  4
			jmp      code_1de4
code_0ac3:
			pushi    1
			lofss    'caress/locker,top,bay'
			callk    Said,  2
			bnt      code_0add
			pushi    2
			pushi    370
			pushi    42
			calle    proc255_0,  4
			jmp      code_1de4
code_0add:
			pushi    1
			lofss    '(look<in),explore,(look<in)/locker,(door<locker)'
			callk    Said,  2
			bnt      code_0bbb
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_0b08
			pushi    2
			pushi    370
			pushi    43
			calle    proc255_0,  4
			jmp      code_0bb8
code_0b08:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_0b29
			pushi    2
			pushi    370
			pushi    44
			calle    proc255_0,  4
			jmp      code_0bb8
code_0b29:
			pushi    1
			pushi    51
			callb    proc0_22,  2
			bnt      code_0b5b
			pushi    2
			pushi    370
			pushi    45
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    46
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    47
			calle    proc255_0,  4
			jmp      code_0bb8
code_0b5b:
			lsg      gGNumber_2
			ldi      7
			eq?     
			bnt      code_0b71
			pushi    2
			pushi    370
			pushi    48
			calle    proc255_0,  4
			jmp      code_0bb8
code_0b71:
			lsg      gGNumber_2
			ldi      8
			eq?     
			bnt      code_0b87
			pushi    2
			pushi    370
			pushi    49
			calle    proc255_0,  4
			jmp      code_0bb8
code_0b87:
			lsg      gGNumber_2
			ldi      9
			eq?     
			bnt      code_0b9d
			pushi    2
			pushi    370
			pushi    50
			calle    proc255_0,  4
			jmp      code_0bb8
code_0b9d:
			lsg      gGNumber_2
			ldi      5
			eq?     
			bt       code_0bab
			lsg      gGNumber_2
			ldi      6
			eq?     
			bnt      code_0bb8
code_0bab:
			pushi    2
			pushi    370
			pushi    49
			calle    proc255_0,  4
code_0bb8:
			jmp      code_1de4
code_0bbb:
			pushi    1
			lofss    'get,spray,wear,use/can,spray,deodorant'
			callk    Said,  2
			bnt      code_0c8a
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_0be6
			pushi    2
			pushi    370
			pushi    51
			calle    proc255_0,  4
			jmp      code_0c87
code_0be6:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_0c07
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_0c87
code_0c07:
			lsg      gGNumber_2
			ldi      5
			eq?     
			bt       code_0c1c
			lsg      gGNumber_2
			ldi      6
			eq?     
			bt       code_0c1c
			lsg      gGNumber_2
			ldi      8
			eq?     
			bnt      code_0c68
code_0c1c:
			pushi    2
			pushi    370
			pushi    52
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    52
			calle    proc255_0,  4
			pushi    1
			pushi    62
			callb    proc0_20,  2
			pushi    1
			pushi    60
			callb    proc0_22,  2
			not     
			bnt      code_0c59
			pushi    1
			pushi    60
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    27
			lag      gGame
			send     6
code_0c59:
			pushi    2
			pushi    370
			pushi    53
			calle    proc255_0,  4
			jmp      code_0c87
code_0c68:
			pushi    5
			pushi    370
			pushi    54
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
			pushi    #changeScore
			pushi    1
			pushi    65535
			lag      gGame
			send     6
code_0c87:
			jmp      code_1de4
code_0c8a:
			pushi    1
			lofss    'dry,dry[/body,i]'
			callk    Said,  2
			bt       code_0cb3
			pushi    1
			lofss    'caress/self,i'
			callk    Said,  2
			bt       code_0cb3
			pushi    1
			lofss    'dry'
			callk    Said,  2
			bt       code_0cb3
			pushi    1
			lofss    'use,(dry<with),(dry<off)/towel'
			callk    Said,  2
			bnt      code_0d70
code_0cb3:
			pushi    #has
			pushi    1
			pushi    8
			lag      gEgo
			send     6
			not     
			bnt      code_0cd1
			pushi    2
			pushi    370
			pushi    55
			calle    proc255_0,  4
			jmp      code_0d6d
code_0cd1:
			lsg      gGNumber_2
			ldi      8
			ne?     
			bnt      code_0cf5
			lsg      gGNumber_2
			ldi      6
			ne?     
			bnt      code_0cf5
			lsg      gGNumber_2
			ldi      5
			ne?     
			bnt      code_0cf5
			pushi    2
			pushi    370
			pushi    56
			calle    proc255_0,  4
			jmp      code_0d6d
code_0cf5:
			pushi    1
			pushi    50
			callb    proc0_22,  2
			not     
			bnt      code_0d0e
			pushi    2
			pushi    370
			pushi    57
			calle    proc255_0,  4
			jmp      code_0d6d
code_0d0e:
			lsg      gGNumber_2
			ldi      8
			ne?     
			bnt      code_0d35
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_0d35
			pushi    2
			pushi    370
			pushi    58
			calle    proc255_0,  4
			jmp      code_0d6d
code_0d35:
			pushi    1
			pushi    50
			callb    proc0_20,  2
			pushi    1
			pushi    39
			callb    proc0_22,  2
			not     
			bnt      code_0d58
			pushi    1
			pushi    39
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    22
			lag      gGame
			send     6
code_0d58:
			pushi    6
			pushi    370
			pushi    59
			pushi    82
			pushi    8
			pushi    0
			pushi    0
			calle    proc255_0,  12
code_0d6d:
			jmp      code_1de4
code_0d70:
			pushi    1
			lofss    'address'
			callk    Said,  2
			bnt      code_0d8a
			pushi    2
			pushi    370
			pushi    60
			calle    proc255_0,  4
			jmp      code_1de4
code_0d8a:
			pushi    1
			lofss    '/combination'
			callk    Said,  2
			bt       code_0d9e
			pushi    1
			lofss    'are<where,what/combination,locker'
			callk    Said,  2
			bnt      code_0dae
code_0d9e:
			pushi    2
			pushi    370
			pushi    61
			calle    proc255_0,  4
			jmp      code_1de4
code_0dae:
			pushi    1
			lofss    'look>'
			callk    Said,  2
			bnt      code_0f87
			pushi    1
			lofss    '/man'
			callk    Said,  2
			bnt      code_0dd3
			pushi    2
			pushi    370
			pushi    62
			calle    proc255_0,  4
			jmp      code_0f84
code_0dd3:
			pushi    1
			lofss    '/door,door'
			callk    Said,  2
			bnt      code_0e50
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      2
			and     
			bnt      code_0dfb
			pushi    2
			pushi    370
			pushi    63
			calle    proc255_0,  4
			jmp      code_0e4d
code_0dfb:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      8
			and     
			bnt      code_0e33
			pushi    2
			pushi    370
			pushi    64
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    65
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    66
			calle    proc255_0,  4
			jmp      code_0e4d
code_0e33:
			pushi    2
			pushi    370
			pushi    67
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    68
			calle    proc255_0,  4
code_0e4d:
			jmp      code_0f84
code_0e50:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			bnt      code_0e7a
			pushi    1
			lofss    '/art'
			callk    Said,  2
			bnt      code_0e7a
			pushi    2
			pushi    370
			pushi    69
			calle    proc255_0,  4
			jmp      code_0f84
code_0e7a:
			pushi    1
			lofss    '/number'
			callk    Said,  2
			bnt      code_0ee1
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			bt       code_0ea3
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      128
			and     
			bnt      code_0eb2
code_0ea3:
			pushi    2
			pushi    370
			pushi    70
			calle    proc255_0,  4
			jmp      code_0ede
code_0eb2:
			pushi    3
			pushi    370
			pushi    71
			pushi    2
			pushi    1
			pushi    999
			callk    Random,  4
			push    
			calle    proc255_4,  6
			pushi    5
			pushi    370
			pushi    72
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
code_0ede:
			jmp      code_0f84
code_0ee1:
			pushi    1
			lofss    '/locker'
			callk    Said,  2
			bnt      code_0efb
			pushi    2
			pushi    370
			pushi    73
			calle    proc255_0,  4
			jmp      code_0f84
code_0efb:
			pushi    1
			lofss    '/locker<my'
			callk    Said,  2
			bnt      code_0f14
			pushi    2
			pushi    370
			pushi    61
			calle    proc255_0,  4
			jmp      code_0f84
code_0f14:
			pushi    1
			lofss    '/locker,bay'
			callk    Said,  2
			bnt      code_0f2d
			pushi    2
			pushi    370
			pushi    74
			calle    proc255_0,  4
			jmp      code_0f84
code_0f2d:
			pushi    1
			lofss    '/sweatpants'
			callk    Said,  2
			bnt      code_0f54
			lsg      gGNumber_2
			ldi      9
			ne?     
			bnt      code_0f45
			pushi    0
			callb    proc0_12,  0
			jmp      code_0f52
code_0f45:
			pushi    2
			pushi    370
			pushi    75
			calle    proc255_0,  4
code_0f52:
			jmp      code_0f84
code_0f54:
			pushi    1
			lofss    '/deodorant,can,spray'
			callk    Said,  2
			bnt      code_0f6d
			pushi    2
			pushi    370
			pushi    76
			calle    proc255_0,  4
			jmp      code_0f84
code_0f6d:
			pushi    1
			lofss    '[/area]'
			callk    Said,  2
			bnt      code_0f84
			pushi    2
			pushi    370
			pushi    77
			calle    proc255_0,  4
code_0f84:
			jmp      code_1de4
code_0f87:
			pushi    1
			lofss    '/69'
			callk    Said,  2
			bt       code_0f9b
			pushi    1
			lofss    '//69'
			callk    Said,  2
			bnt      code_0fab
code_0f9b:
			pushi    2
			pushi    370
			pushi    78
			calle    proc255_0,  4
			jmp      code_1de4
code_0fab:
			pushi    #type
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      1
			eq?     
			bnt      code_1de4
			pushi    #modifiers
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      3
			and     
			not     
			bnt      code_1de4
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      302
			gt?     
			bnt      code_1038
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      319
			lt?     
			bnt      code_1038
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      148
			gt?     
			bnt      code_1038
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      175
			lt?     
			bnt      code_1038
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      999
			eq?     
			bnt      code_102d
			pushi    #setMotion
			pushi    3
			class    MoveTo
			push    
			pushi    321
			pushi    169
			lag      gEgo
			send     10
			jmp      code_1037
code_102d:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_1037:
			toss    
code_1038:
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      7
			gt?     
			bnt      code_12b8
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      305
			lt?     
			bnt      code_12b8
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      70
			gt?     
			bnt      code_12b8
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      145
			lt?     
			bnt      code_12b8
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_116d
			pushi    2
			pushi    370
			pushi    77
			calle    proc255_0,  4
			pushi    4
			pushi    #x
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #y
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    88
			pushi    65
			callk    GetDistance,  8
			sal      local4
			push    
			ldi      150
			gt?     
			bnt      code_10cb
			pushi    2
			pushi    370
			pushi    34
			calle    proc255_0,  4
			jmp      code_116a
code_10cb:
			lsl      local4
			ldi      80
			gt?     
			bnt      code_10e2
			pushi    2
			pushi    370
			pushi    35
			calle    proc255_0,  4
			jmp      code_116a
code_10e2:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      512
			and     
			bnt      code_1101
			pushi    2
			pushi    370
			pushi    36
			calle    proc255_0,  4
			jmp      code_116a
code_1101:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      256
			and     
			bnt      code_1120
			pushi    2
			pushi    370
			pushi    37
			calle    proc255_0,  4
			jmp      code_116a
code_1120:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      128
			and     
			bnt      code_113f
			pushi    2
			pushi    370
			pushi    38
			calle    proc255_0,  4
			jmp      code_116a
code_113f:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			bnt      code_115d
			pushi    2
			pushi    370
			pushi    39
			calle    proc255_0,  4
			jmp      code_116a
code_115d:
			pushi    2
			pushi    370
			pushi    40
			calle    proc255_0,  4
code_116a:
			jmp      code_12b7
code_116d:
			dup     
			ldi      995
			eq?     
			bnt      code_12ad
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			bnt      code_118d
			pushi    0
			callb    proc0_7,  0
			jmp      code_12ab
code_118d:
			pushi    2
			pushi    370
			pushi    10
			calle    proc255_0,  4
code_119a:
			lsl      local0
			ldi      0
			le?     
			bnt      code_11b0
			pushi    1
			lofss    {Primer  N{mero:}
			calle    proc255_3,  2
			sal      local0
			jmp      code_119a
code_11b0:
			lsl      local1
			ldi      0
			le?     
			bnt      code_11c6
			pushi    1
			lofss    {Segundo N{mero:}
			calle    proc255_3,  2
			sal      local1
			jmp      code_11b0
code_11c6:
			lsl      local2
			ldi      0
			le?     
			bnt      code_11dc
			pushi    1
			lofss    {Tercer N{mero:}
			calle    proc255_3,  2
			sal      local2
			jmp      code_11c6
code_11dc:
			pushi    6
			pushi    370
			pushi    11
			lsl      local0
			lsl      local0
			lsl      local1
			lsl      local2
			calle    proc255_4,  12
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_1211
			pushi    2
			pushi    370
			pushi    12
			calle    proc255_0,  4
			jmp      code_129f
code_1211:
			lsl      local0
			lag      global111
			ne?     
			bt       code_1226
			lsl      local1
			lag      global112
			ne?     
			bt       code_1226
			lsl      local2
			lag      global113
			ne?     
			bnt      code_1235
code_1226:
			pushi    2
			pushi    370
			pushi    13
			calle    proc255_0,  4
			jmp      code_129f
code_1235:
			pushi    1
			pushi    40
			callb    proc0_22,  2
			not     
			bnt      code_1260
			pushi    1
			pushi    40
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    100
			lag      gGame
			send     6
			pushi    2
			pushi    370
			pushi    14
			calle    proc255_0,  4
			jmp      code_126d
code_1260:
			pushi    2
			pushi    370
			pushi    15
			calle    proc255_0,  4
code_126d:
			lsl      local205
			ldi      0
			eq?     
			bnt      code_128a
			pushi    #posn
			pushi    2
			pushi    88
			pushi    65
			lofsa    aLocker
			send     8
			ldi      1
			sal      local205
			jmp      code_129f
code_128a:
			ldi      0
			sal      local205
			pushi    #posn
			pushi    2
			pushi    1111
			pushi    1111
			lofsa    aLocker
			send     8
code_129f:
			ldi      0
			sal      local0
			ldi      0
			sal      local1
			ldi      0
			sal      local2
code_12ab:
			jmp      code_12b7
code_12ad:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_12b7:
			toss    
code_12b8:
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      76
			gt?     
			bnt      code_1de4
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      96
			lt?     
			bnt      code_1de4
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      56
			gt?     
			bnt      code_1de4
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      70
			lt?     
			bnt      code_1de4
			pushi    #contains
			pushi    1
			lofss    aLocker
			lag      gCast
			send     6
			bnt      code_1de4
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_13ec
			pushi    4
			pushi    #x
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    #y
			pushi    0
			lag      gEgo
			send     4
			push    
			pushi    88
			pushi    65
			callk    GetDistance,  8
			sal      local4
			push    
			ldi      150
			gt?     
			bnt      code_134a
			pushi    2
			pushi    370
			pushi    34
			calle    proc255_0,  4
			jmp      code_13e9
code_134a:
			lsl      local4
			ldi      80
			gt?     
			bnt      code_1361
			pushi    2
			pushi    370
			pushi    35
			calle    proc255_0,  4
			jmp      code_13e9
code_1361:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      512
			and     
			bnt      code_1380
			pushi    2
			pushi    370
			pushi    36
			calle    proc255_0,  4
			jmp      code_13e9
code_1380:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      256
			and     
			bnt      code_139f
			pushi    2
			pushi    370
			pushi    37
			calle    proc255_0,  4
			jmp      code_13e9
code_139f:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      128
			and     
			bnt      code_13be
			pushi    2
			pushi    370
			pushi    38
			calle    proc255_0,  4
			jmp      code_13e9
code_13be:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			bnt      code_13dc
			pushi    2
			pushi    370
			pushi    39
			calle    proc255_0,  4
			jmp      code_13e9
code_13dc:
			pushi    2
			pushi    370
			pushi    40
			calle    proc255_0,  4
code_13e9:
			jmp      code_1ac8
code_13ec:
			dup     
			ldi      995
			eq?     
			bnt      code_1547
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			bnt      code_144b
			pushi    0
			callb    proc0_7,  0
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_1421
			pushi    0
			callb    proc0_7,  0
			jmp      code_1448
code_1421:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_1438
			pushi    0
			callb    proc0_10,  0
			jmp      code_1448
code_1438:
			pushi    #posn
			pushi    2
			pushi    1111
			pushi    1111
			lofsa    aLocker
			send     8
code_1448:
			jmp      code_1544
code_144b:
			pushi    2
			pushi    370
			pushi    10
			calle    proc255_0,  4
code_1458:
			lsl      local0
			ldi      0
			le?     
			bnt      code_146e
			pushi    1
			lofss    {Primer n{mero:}
			calle    proc255_3,  2
			sal      local0
			jmp      code_1458
code_146e:
			lsl      local1
			ldi      0
			le?     
			bnt      code_1484
			pushi    1
			lofss    {Segundo N{mero:}
			calle    proc255_3,  2
			sal      local1
			jmp      code_146e
code_1484:
			lsl      local2
			ldi      0
			le?     
			bnt      code_149a
			pushi    1
			lofss    {Tercer N{mero:}
			calle    proc255_3,  2
			sal      local2
			jmp      code_1484
code_149a:
			pushi    6
			pushi    370
			pushi    11
			lsl      local0
			lsl      local0
			lsl      local1
			lsl      local2
			calle    proc255_4,  12
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_14ce
			pushi    2
			pushi    370
			pushi    12
			calle    proc255_0,  4
			jmp      code_1538
code_14ce:
			lsl      local0
			lag      global111
			ne?     
			bt       code_14e3
			lsl      local1
			lag      global112
			ne?     
			bt       code_14e3
			lsl      local2
			lag      global113
			ne?     
			bnt      code_14f2
code_14e3:
			pushi    2
			pushi    370
			pushi    13
			calle    proc255_0,  4
			jmp      code_1538
code_14f2:
			pushi    1
			pushi    40
			callb    proc0_22,  2
			not     
			bnt      code_151d
			pushi    1
			pushi    40
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    100
			lag      gGame
			send     6
			pushi    2
			pushi    370
			pushi    14
			calle    proc255_0,  4
			jmp      code_152a
code_151d:
			pushi    2
			pushi    370
			pushi    15
			calle    proc255_0,  4
code_152a:
			pushi    #posn
			pushi    2
			pushi    88
			pushi    65
			lofsa    aLocker
			send     8
code_1538:
			ldi      0
			sal      local0
			ldi      0
			sal      local1
			ldi      0
			sal      local2
code_1544:
			jmp      code_1ac8
code_1547:
			dup     
			ldi      8
			eq?     
			bnt      code_160b
			pushi    #has
			pushi    1
			pushi    8
			lag      gEgo
			send     6
			not     
			bnt      code_156c
			pushi    2
			pushi    370
			pushi    55
			calle    proc255_0,  4
			jmp      code_1608
code_156c:
			lsg      gGNumber_2
			ldi      8
			ne?     
			bnt      code_1590
			lsg      gGNumber_2
			ldi      6
			ne?     
			bnt      code_1590
			lsg      gGNumber_2
			ldi      5
			ne?     
			bnt      code_1590
			pushi    2
			pushi    370
			pushi    56
			calle    proc255_0,  4
			jmp      code_1608
code_1590:
			pushi    1
			pushi    50
			callb    proc0_22,  2
			not     
			bnt      code_15a9
			pushi    2
			pushi    370
			pushi    57
			calle    proc255_0,  4
			jmp      code_1608
code_15a9:
			lsg      gGNumber_2
			ldi      8
			ne?     
			bnt      code_15d0
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_15d0
			pushi    2
			pushi    370
			pushi    58
			calle    proc255_0,  4
			jmp      code_1608
code_15d0:
			pushi    1
			pushi    50
			callb    proc0_20,  2
			pushi    1
			pushi    39
			callb    proc0_22,  2
			not     
			bnt      code_15f3
			pushi    1
			pushi    39
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    22
			lag      gGame
			send     6
code_15f3:
			pushi    6
			pushi    370
			pushi    59
			pushi    82
			pushi    8
			pushi    0
			pushi    0
			calle    proc255_0,  12
code_1608:
			jmp      code_1ac8
code_160b:
			dup     
			ldi      994
			eq?     
			bnt      code_1ac8
			pushi    16
			lofss    {&Qu+ quieres hacer?}
			pushi    81
			lofss    {Desodorante}
			pushi    1
			pushi    81
			lofss    {Toalla}
			pushi    2
			pushi    81
			lofss    {Desnudo}
			pushi    3
			pushi    81
			lofss    {Chandal Femenino}
			pushi    4
			pushi    81
			lofss    {Traje Blanco}
			pushi    5
			calle    proc255_6,  32
			sal      local206
			lsl      local206
			dup     
			ldi      1
			eq?     
			bnt      code_1712
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_166e
			pushi    2
			pushi    370
			pushi    51
			calle    proc255_0,  4
			jmp      code_170f
code_166e:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_168f
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_170f
code_168f:
			lsg      gGNumber_2
			ldi      5
			eq?     
			bt       code_16a4
			lsg      gGNumber_2
			ldi      6
			eq?     
			bt       code_16a4
			lsg      gGNumber_2
			ldi      8
			eq?     
			bnt      code_16f0
code_16a4:
			pushi    2
			pushi    370
			pushi    52
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    52
			calle    proc255_0,  4
			pushi    1
			pushi    62
			callb    proc0_20,  2
			pushi    1
			pushi    60
			callb    proc0_22,  2
			not     
			bnt      code_16e1
			pushi    1
			pushi    60
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    27
			lag      gGame
			send     6
code_16e1:
			pushi    2
			pushi    370
			pushi    53
			calle    proc255_0,  4
			jmp      code_170f
code_16f0:
			pushi    5
			pushi    370
			pushi    54
			pushi    67
			pushi    65535
			pushi    144
			calle    proc255_0,  10
			pushi    #changeScore
			pushi    1
			pushi    65535
			lag      gGame
			send     6
code_170f:
			jmp      code_1ac7
code_1712:
			dup     
			ldi      2
			eq?     
			bnt      code_17c4
			lsg      gGNumber_2
			ldi      8
			eq?     
			bnt      code_1730
			pushi    2
			pushi    370
			pushi    28
			calle    proc255_0,  4
			jmp      code_17c1
code_1730:
			pushi    #has
			pushi    1
			pushi    8
			lag      gEgo
			send     6
			not     
			bnt      code_1745
			pushi    0
			callb    proc0_12,  0
			jmp      code_17c1
code_1745:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_1764
			pushi    2
			pushi    370
			pushi    29
			calle    proc255_0,  4
			jmp      code_17c1
code_1764:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_1784
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_17c1
code_1784:
			pushi    1
			pushi    51
			callb    proc0_22,  2
			bnt      code_17a7
			pushi    2
			pushi    370
			pushi    26
			calle    proc255_0,  4
			pushi    1
			lofss    {Debes restaurar el juego.}
			calle    proc255_0,  2
			jmp      code_17c1
code_17a7:
			pushi    3
			lea      @local5
			push    
			pushi    370
			pushi    30
			callk    Format,  6
			ldi      8
			sag      gGNumber_2
			pushi    #changeState
			pushi    1
			pushi    1
			self     6
code_17c1:
			jmp      code_1ac7
code_17c4:
			dup     
			ldi      3
			eq?     
			bnt      code_1851
			lsg      gGNumber_2
			ldi      5
			eq?     
			bt       code_17d9
			lsg      gGNumber_2
			ldi      6
			eq?     
			bnt      code_17e8
code_17d9:
			pushi    2
			pushi    370
			pushi    19
			calle    proc255_0,  4
			jmp      code_184e
code_17e8:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_1807
			pushi    2
			pushi    370
			pushi    20
			calle    proc255_0,  4
			jmp      code_184e
code_1807:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_1827
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_184e
code_1827:
			pushi    3
			lea      @local5
			push    
			pushi    370
			pushi    22
			callk    Format,  6
			lsg      global88
			ldi      3
			lt?     
			bnt      code_1842
			ldi      6
			sag      gGNumber_2
			jmp      code_1846
code_1842:
			ldi      5
			sag      gGNumber_2
code_1846:
			pushi    #changeState
			pushi    1
			pushi    1
			self     6
code_184e:
			jmp      code_1ac7
code_1851:
			dup     
			ldi      4
			eq?     
			bnt      code_1923
			lsg      gGNumber_2
			ldi      9
			eq?     
			bnt      code_186f
			pushi    2
			pushi    370
			pushi    31
			calle    proc255_0,  4
			jmp      code_1920
code_186f:
			pushi    1
			pushi    50
			callb    proc0_22,  2
			bnt      code_1888
			pushi    2
			pushi    370
			pushi    32
			calle    proc255_0,  4
			jmp      code_1920
code_1888:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_18a7
			pushi    2
			pushi    370
			pushi    25
			calle    proc255_0,  4
			jmp      code_1920
code_18a7:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_18c7
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_1920
code_18c7:
			pushi    1
			pushi    51
			callb    proc0_22,  2
			bnt      code_18ea
			pushi    2
			pushi    370
			pushi    26
			calle    proc255_0,  4
			pushi    1
			lofss    {Debes restaurar el juego.}
			calle    proc255_0,  2
			jmp      code_1920
code_18ea:
			pushi    3
			lea      @local5
			push    
			pushi    370
			pushi    33
			callk    Format,  6
			ldi      9
			sag      gGNumber_2
			pushi    1
			pushi    41
			callb    proc0_22,  2
			not     
			bnt      code_1918
			pushi    1
			pushi    41
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    4
			lag      gGame
			send     6
code_1918:
			pushi    #changeState
			pushi    1
			pushi    1
			self     6
code_1920:
			jmp      code_1ac7
code_1923:
			dup     
			ldi      5
			eq?     
			bnt      code_19d8
			lsg      gGNumber_2
			ldi      7
			eq?     
			bnt      code_1941
			pushi    2
			pushi    370
			pushi    23
			calle    proc255_0,  4
			jmp      code_19d5
code_1941:
			pushi    1
			pushi    50
			callb    proc0_22,  2
			bnt      code_1959
			pushi    2
			pushi    370
			pushi    24
			calle    proc255_0,  4
			jmp      code_19d5
code_1959:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_1978
			pushi    2
			pushi    370
			pushi    25
			calle    proc255_0,  4
			jmp      code_19d5
code_1978:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_1998
			pushi    2
			pushi    370
			pushi    21
			calle    proc255_0,  4
			jmp      code_19d5
code_1998:
			pushi    1
			pushi    51
			callb    proc0_22,  2
			bnt      code_19bb
			pushi    2
			pushi    370
			pushi    26
			calle    proc255_0,  4
			pushi    1
			lofss    {Debes restaurar el juego.}
			calle    proc255_0,  2
			jmp      code_19d5
code_19bb:
			pushi    3
			lea      @local5
			push    
			pushi    370
			pushi    27
			callk    Format,  6
			ldi      7
			sag      gGNumber_2
			pushi    #changeState
			pushi    1
			pushi    1
			self     6
code_19d5:
			jmp      code_1ac7
code_19d8:
			dup     
			ldi      998
			eq?     
			bnt      code_1abd
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      64
			and     
			not     
			bnt      code_1a00
			pushi    2
			pushi    370
			pushi    43
			calle    proc255_0,  4
			jmp      code_1abb
code_1a00:
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_1a21
			pushi    2
			pushi    370
			pushi    44
			calle    proc255_0,  4
			jmp      code_1abb
code_1a21:
			pushi    1
			pushi    51
			callb    proc0_22,  2
			bnt      code_1a5e
			pushi    2
			pushi    370
			pushi    45
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    46
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    47
			calle    proc255_0,  4
			pushi    1
			lofss    {Debes restaurar el juego.}
			calle    proc255_0,  2
			jmp      code_1abb
code_1a5e:
			lsg      gGNumber_2
			ldi      7
			eq?     
			bnt      code_1a74
			pushi    2
			pushi    370
			pushi    48
			calle    proc255_0,  4
			jmp      code_1abb
code_1a74:
			lsg      gGNumber_2
			ldi      8
			eq?     
			bnt      code_1a8a
			pushi    2
			pushi    370
			pushi    49
			calle    proc255_0,  4
			jmp      code_1abb
code_1a8a:
			lsg      gGNumber_2
			ldi      9
			eq?     
			bnt      code_1aa0
			pushi    2
			pushi    370
			pushi    50
			calle    proc255_0,  4
			jmp      code_1abb
code_1aa0:
			lsg      gGNumber_2
			ldi      5
			eq?     
			bt       code_1aae
			lsg      gGNumber_2
			ldi      6
			eq?     
			bnt      code_1abb
code_1aae:
			pushi    2
			pushi    370
			pushi    49
			calle    proc255_0,  4
code_1abb:
			jmp      code_1ac7
code_1abd:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_1ac7:
			toss    
code_1ac8:
			toss    
			pushi    3
			lsg      gEgo
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bnt      code_1bb1
			lsg      gCursorNumber
			ldi      8
			eq?     
			bnt      code_1bb1
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			pushi    #has
			pushi    1
			pushi    8
			lag      gEgo
			send     6
			not     
			bnt      code_1b15
			pushi    2
			pushi    370
			pushi    55
			calle    proc255_0,  4
			jmp      code_1bb1
code_1b15:
			lsg      gGNumber_2
			ldi      8
			ne?     
			bnt      code_1b39
			lsg      gGNumber_2
			ldi      6
			ne?     
			bnt      code_1b39
			lsg      gGNumber_2
			ldi      5
			ne?     
			bnt      code_1b39
			pushi    2
			pushi    370
			pushi    56
			calle    proc255_0,  4
			jmp      code_1bb1
code_1b39:
			pushi    1
			pushi    50
			callb    proc0_22,  2
			not     
			bnt      code_1b52
			pushi    2
			pushi    370
			pushi    57
			calle    proc255_0,  4
			jmp      code_1bb1
code_1b52:
			lsg      gGNumber_2
			ldi      8
			ne?     
			bnt      code_1b79
			pushi    #y
			pushi    0
			lofsa    aLocker
			send     4
			push    
			ldi      999
			lt?     
			not     
			bnt      code_1b79
			pushi    2
			pushi    370
			pushi    58
			calle    proc255_0,  4
			jmp      code_1bb1
code_1b79:
			pushi    1
			pushi    50
			callb    proc0_20,  2
			pushi    1
			pushi    39
			callb    proc0_22,  2
			not     
			bnt      code_1b9c
			pushi    1
			pushi    39
			callb    proc0_19,  2
			pushi    #changeScore
			pushi    1
			pushi    22
			lag      gGame
			send     6
code_1b9c:
			pushi    6
			pushi    370
			pushi    59
			pushi    82
			pushi    8
			pushi    0
			pushi    0
			calle    proc255_0,  12
code_1bb1:
			pushi    3
			lofss    aMan1
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bt       code_1c05
			pushi    3
			lofss    aMan2
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bt       code_1c05
			pushi    3
			lofss    aMan3
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			callb    proc0_26,  6
			bnt      code_1c48
code_1c05:
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_1c27
			pushi    2
			pushi    370
			pushi    62
			calle    proc255_0,  4
			jmp      code_1c47
code_1c27:
			dup     
			ldi      996
			eq?     
			bnt      code_1c3d
			pushi    2
			pushi    370
			pushi    60
			calle    proc255_0,  4
			jmp      code_1c47
code_1c3d:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_1c47:
			toss    
code_1c48:
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      207
			gt?     
			bnt      code_1d16
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      235
			lt?     
			bnt      code_1d16
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      21
			gt?     
			bnt      code_1d16
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      57
			lt?     
			bnt      code_1d16
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_1d0b
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      2
			and     
			bnt      code_1cb7
			pushi    2
			pushi    370
			pushi    63
			calle    proc255_0,  4
			jmp      code_1d09
code_1cb7:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      8
			and     
			bnt      code_1cef
			pushi    2
			pushi    370
			pushi    64
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    65
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    66
			calle    proc255_0,  4
			jmp      code_1d09
code_1cef:
			pushi    2
			pushi    370
			pushi    67
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    68
			calle    proc255_0,  4
code_1d09:
			jmp      code_1d15
code_1d0b:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_1d15:
			toss    
code_1d16:
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      288
			gt?     
			bnt      code_1de4
			pushi    #x
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      319
			lt?     
			bnt      code_1de4
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      21
			gt?     
			bnt      code_1de4
			pushi    #y
			pushi    0
			lap      pEvent
			send     4
			push    
			ldi      67
			lt?     
			bnt      code_1de4
			pushi    #claimed
			pushi    1
			pushi    1
			lap      pEvent
			send     6
			lsg      gCursorNumber
			dup     
			ldi      998
			eq?     
			bnt      code_1dd9
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      2
			and     
			bnt      code_1d85
			pushi    2
			pushi    370
			pushi    63
			calle    proc255_0,  4
			jmp      code_1dd7
code_1d85:
			pushi    #onControl
			pushi    0
			lag      gEgo
			send     4
			push    
			ldi      8
			and     
			bnt      code_1dbd
			pushi    2
			pushi    370
			pushi    64
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    65
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    66
			calle    proc255_0,  4
			jmp      code_1dd7
code_1dbd:
			pushi    2
			pushi    370
			pushi    67
			calle    proc255_0,  4
			pushi    2
			pushi    370
			pushi    68
			calle    proc255_0,  4
code_1dd7:
			jmp      code_1de3
code_1dd9:
			pushi    #claimed
			pushi    1
			pushi    0
			lap      pEvent
			send     6
code_1de3:
			toss    
code_1de4:
			ret     
		)
	)
)

(instance aLocker of View
	(properties
		y 1111
		x 1111
		view 370
		loop 2
	)
)

(instance aMan1 of Act
	(properties
		view 370
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			posn: (Random 80 200) 14
			setStep: 1 1
			setCycle: Walk
			setScript: Man1Script
		)
	)
)

(instance Man1Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 6)))
			(1
				(aMan1 setMotion: MoveTo (Random 81 200) 14 self)
			)
			(2 (= seconds (Random 6 12)))
			(3
				(aMan1 setMotion: MoveTo (Random 80 100) 14 self)
				(= state -1)
			)
		)
	)
)

(instance aMan2 of Act
	(properties
		view 370
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			posn: (Random -60 1) 8
			setStep: 1 1
			setCycle: Walk
			setScript: Man2Script
		)
	)
)

(instance Man2Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 6)))
			(1
				(aMan2 setMotion: MoveTo (Random 2 40) 8 self)
			)
			(2 (= seconds (Random 6 12)))
			(3
				(aMan2 setMotion: MoveTo (Random -60 1) 8 self)
				(= state -1)
			)
		)
	)
)

(instance aMan3 of Act
	(properties
		view 370
	)
	
	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			posn: (Random -60 0) 20
			setStep: 1 1
			setCycle: Walk
			setScript: Man3Script
		)
	)
)

(instance Man3Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 3 6)))
			(1
				(aMan3 setMotion: MoveTo (Random 2 22) 20 self)
			)
			(2 (= seconds (Random 6 12)))
			(3
				(aMan3 setMotion: MoveTo (Random -60 1) 20 self)
				(= state -1)
			)
		)
	)
)
