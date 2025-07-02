;;; Sierra Script 1.0 - (do not remove this comment)
(script# 990)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Obj)

(public
	proc990_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4] = [{Cargar_} {_Salvar_} {Reemplazar} {Reemplazar}]
	[local9 4] = [{Elige una partida que quieres volver a cargar.} {Escribe un nombre a la partida salvada.} {Ya no puedes salvar mas partidas en__esta unidad. Debes reemplazar uno de tus juegos salvados o cambiar el directorio o unidad para salvar esta__partida.} {Ya no puedes salvar mas partidas en__esta unidad. Debes reemplazar uno de tus juegos salvados o cambiar el directorio o unidad para salvar esta__partida.}]
)
(procedure (proc990_0 param1 &tmp temp0 [temp1 33] [temp34 40])
	(asm
code_000e:
		pushi    13
		pushi    990
		pushi    1
		pushi    33
		pushi    0
		pushi    41
		pushi    2
		lea      @temp1
		push    
		lsp      param1
		callk    StrCpy,  4
		push    
		pushi    29
		pushi    81
		lofsa    {OK}
		push    
		pushi    1
		pushi    81
		lofsa    {Cancelar}
		push    
		pushi    0
		calle    proc255_0,  26
		sat      temp0
		not     
		bnt      code_0047
		ldi      0
		ret     
code_0047:
		pushi    1
		lea      @temp1
		push    
		callk    StrLen,  2
		not     
		bnt      code_005c
		pushi    1
		lea      @temp1
		push    
		callk    GetCWD,  2
code_005c:
		pushi    1
		lea      @temp1
		push    
		callk    ValidPath,  2
		bnt      code_0077
		pushi    2
		lsp      param1
		lea      @temp1
		push    
		callk    StrCpy,  4
		ldi      1
		ret     
		jmp      code_000e
code_0077:
		pushi    3
		pushi    4
		lea      @temp34
		push    
		pushi    990
		pushi    2
		lea      @temp1
		push    
		callk    Format,  8
		push    
		pushi    33
		pushi    0
		calle    proc255_0,  6
		jmp      code_000e
		ret     
	)
)

(procedure (localproc_009a)
	(return
		(cond 
			((== self Cargar_) 0)
			((localproc_00b9) 1)
			(local2 2)
			(else 3)
		)
	)
)

(procedure (localproc_00b9)
	(if (< local2 20) (CheckFreeSpace global30))
)

(procedure (localproc_00c7)
	(proc255_0 990 3 33 0)
)

(class SysWindow of Obj
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 15
		priority -1
		window 0
		type $0000
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
	)
	
	(method (dispose)
		(if window (DisposeWindow window) (= window 0))
		(super dispose:)
	)
	
	(method (open)
		(= window
			(NewWindow
				top
				left
				bottom
				right
				title
				type
				priority
				color
				back
			)
		)
	)
)

(class SRDialog of Dialog
	(properties
		elements 0
		size 0
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		seconds 0
		lastSeconds 0
	)
	
	(method (init param1 param2 param3)
		(= window SysWindow)
		(= nsBottom 0)
		(if
			(==
				(= local2 (GetSaveFiles (gGame name?) param2 param3))
				-1
			)
			(return 0)
		)
		(if (== (= local4 (localproc_009a)) 1)
			(editI
				text: (StrCpy param1 param2)
				font: global23
				setSize:
				moveTo: 4 4
			)
			(self add: editI setSize:)
		)
		(selectorI
			text: param2
			font: global23
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: 2
		)
		(= local1 (+ (selectorI nsRight?) 4))
		(okI
			text: [local5 local4]
			setSize:
			moveTo: local1 (selectorI nsTop?)
			state: (if (== local4 3) 0 else 3)
		)
		(cancelI
			setSize:
			moveTo: local1 (+ (okI nsBottom?) 4)
			state: (& (cancelI state?) $fff7)
		)
		(changeDirI
			setSize:
			moveTo: local1 (+ (cancelI nsBottom?) 4)
			state: (& (changeDirI state?) $fff7)
		)
		(self add: selectorI okI cancelI changeDirI setSize:)
		(textI
			text: [local9 local4]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local1 (+ (textI nsBottom?) 4))
		(self eachElementDo: #move 0 local1)
		(self add: textI setSize: center: open: 4 15)
		(return 1)
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2 temp3 [temp4 361] [temp365 21] [temp386 40])
		(asm
			pushSelf
			class    Cargar_
			eq?     
			bnt      code_02cc
			lap      argc
			bnt      code_02cc
			lap      param1
			bnt      code_02cc
			pushi    1
			pushi    4
			lea      @temp386
			push    
			pushi    990
			pushi    0
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			callk    Format,  8
			push    
			callk    FOpen,  2
			sat      temp1
			push    
			ldi      65535
			eq?     
			bnt      code_02c5
			ret     
code_02c5:
			pushi    1
			lst      temp1
			callk    FClose,  2
code_02cc:
			pushi    #init
			pushi    3
			lsp      param1
			lea      @temp4
			push    
			lea      @temp365
			push    
			self     10
			not     
			bnt      code_02e4
			ldi      65535
			ret     
code_02e4:
			lsl      local4
			dup     
			ldi      0
			eq?     
			bnt      code_02fa
			lal      local2
			bnt      code_0313
			lofsa    okI
			jmp      code_0313
			lofsa    changeDirI
			jmp      code_0313
code_02fa:
			dup     
			ldi      1
			eq?     
			bnt      code_0305
			lofsa    editI
			jmp      code_0313
code_0305:
			dup     
			ldi      2
			eq?     
			bnt      code_0310
			lofsa    okI
			jmp      code_0313
code_0310:
			lofsa    changeDirI
code_0313:
			toss    
			sal      local0
			pushi    #doit
			pushi    1
			push    
			super    Dialog,  6
			sal      local1
			pushi    #indexOf
			pushi    1
			pushi    #cursor
			pushi    0
			lofsa    selectorI
			send     4
			push    
			lofsa    selectorI
			send     6
			sal      local3
			push    
			ldi      18
			mul     
			sat      temp3
			lsl      local1
			lofsa    changeDirI
			eq?     
			bnt      code_03e0
			pushi    1
			lsg      global30
			call     proc990_0,  2
			bnt      code_02e4
			pushi    3
			pushi    #name
			pushi    0
			lag      gGame
			send     4
			push    
			lea      @temp4
			push    
			lea      @temp365
			push    
			callk    GetSaveFiles,  6
			sal      local2
			push    
			ldi      65535
			eq?     
			bnt      code_0375
			ldi      65535
			sat      temp2
			jmp      code_04e6
code_0375:
			lal      local4
			sat      temp0
			pushi    0
			call     localproc_009a,  0
			sal      local4
			push    
			dup     
			ldi      0
			eq?     
			bnt      code_038a
			jmp      code_03d3
code_038a:
			dup     
			lat      temp0
			eq?     
			bnt      code_03bd
			pushi    #contains
			pushi    1
			lofsa    editI
			push    
			self     6
			bnt      code_03d3
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lea      @temp4
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    83
			pushi    0
			lofsa    editI
			send     10
			jmp      code_03d3
code_03bd:
			pushi    #dispose
			pushi    0
			pushi    87
			pushi    3
			lsp      param1
			lea      @temp4
			push    
			lea      @temp365
			push    
			self     14
code_03d3:
			toss    
			pushi    #draw
			pushi    0
			lofsa    selectorI
			send     4
			jmp      code_02e4
code_03e0:
			lsl      local4
			ldi      2
			eq?     
			bnt      code_0416
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_0416
			pushi    #doit
			pushi    1
			pushi    2
			lsp      param1
			lat      temp3
			leai     @temp4
			push    
			callk    StrCpy,  4
			push    
			lofsa    GetReplaceName
			send     6
			bnt      code_02e4
			lal      local3
			lati     temp365
			sat      temp2
			jmp      code_04e6
			jmp      code_02e4
code_0416:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_048e
			lsl      local1
			lofsa    okI
			eq?     
			bt       code_042d
			lsl      local1
			lofsa    editI
			eq?     
			bnt      code_048e
code_042d:
			pushi    1
			lsp      param1
			callk    StrLen,  2
			push    
			ldi      0
			eq?     
			bnt      code_0443
			pushi    0
			call     localproc_00c7,  0
			jmp      code_02e4
code_0443:
			ldi      65535
			sat      temp2
			ldi      0
			sal      local1
code_044b:
			lsl      local1
			lal      local2
			lt?     
			bnt      code_046b
			pushi    2
			lsp      param1
			lsl      local1
			ldi      18
			mul     
			leai     @temp4
			push    
			callk    StrCmp,  4
			sat      temp2
			not     
			bnt      code_0467
code_0467:
			+al      local1
			jmp      code_044b
code_046b:
			lat      temp2
			not     
			bnt      code_0477
			lal      local1
			lati     temp365
			jmp      code_0487
code_0477:
			lsl      local2
			ldi      20
			eq?     
			bnt      code_0485
			lal      local3
			lati     temp365
			jmp      code_0487
code_0485:
			lal      local2
code_0487:
			sat      temp2
			jmp      code_04e6
			jmp      code_02e4
code_048e:
			lsl      local1
			lofsa    okI
			eq?     
			bnt      code_04a2
			lal      local3
			lati     temp365
			sat      temp2
			jmp      code_04e6
			jmp      code_02e4
code_04a2:
			lsl      local1
			ldi      0
			eq?     
			bt       code_04b1
			lsl      local1
			lofsa    cancelI
			eq?     
			bnt      code_04ba
code_04b1:
			ldi      65535
			sat      temp2
			jmp      code_04e6
			jmp      code_02e4
code_04ba:
			lsl      local4
			ldi      1
			eq?     
			bnt      code_02e4
			pushi    #cursor
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lat      temp3
			leai     @temp4
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    83
			pushi    0
			lofsa    editI
			send     10
			jmp      code_02e4
code_04e6:
			pushi    #dispose
			pushi    0
			self     4
			lat      temp2
			ret     
		)
	)
)

(class Cargar_ of SRDialog
	(properties
		elements 0
		size 0
		text {Cargar partida}
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		seconds 0
		lastSeconds 0
		name "Cargar_"
	)
)

(class Save of SRDialog
	(properties
		elements 0
		size 0
		text {__SALVAR___}
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		seconds 0
		lastSeconds 0
	)
)

(instance GetReplaceName of Dialog
	(properties)
	
	(method (doit param1 &tmp temp0)
		(= window SysWindow)
		(text1 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: oldName setSize:)
		(text2 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName
			text: param1
			font: global23
			setSize:
			moveTo: 4 nsBottom
		)
		(self add: newName setSize:)
		(button1 nsLeft: 0 nsTop: 0 setSize:)
		(button2 nsLeft: 0 nsTop: 0 setSize:)
		(button2
			moveTo: (- nsRight (+ (button2 nsRight?) 4)) nsBottom
		)
		(button1
			moveTo: (- (button2 nsLeft?) (+ (button1 nsRight?) 4)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 15)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen param1))
			(localproc_00c7)
			(= temp0 0)
		)
		(return (if (== temp0 newName) else (== temp0 button1)))
	)
)

(instance selectorI of DSelector
	(properties
		x 36
		y 8
	)
)

(instance editI of DEdit
	(properties
		max 35
	)
)

(instance okI of DButton
	(properties)
)

(instance cancelI of DButton
	(properties
		text { Cancelar_}
	)
)

(instance changeDirI of DButton
	(properties
		text {Cambia\0D\n carpeta_}
	)
)

(instance textI of DText
	(properties
		font 0
	)
)

(instance text1 of DText
	(properties
		text {Reemplazar}
		font 0
	)
)

(instance text2 of DText
	(properties
		text {con:}
		font 0
	)
)

(instance oldName of DText
	(properties)
)

(instance newName of DEdit
	(properties
		max 35
	)
)

(instance button1 of DButton
	(properties
		text {Reemplazar}
	)
)

(instance button2 of DButton
	(properties
		text {Cancelar}
	)
)
